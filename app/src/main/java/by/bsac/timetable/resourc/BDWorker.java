package by.bsac.timetable.resourc;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class BDWorker extends SQLiteOpenHelper {
    //Путь к базе данных
    public static String DB_PATH;
    //Имя файла с базой
    public static String DB_NAME="bdtable";
    public SQLiteDatabase database;
    public final Context context;



    public BDWorker(Context context) {
        super(context, DB_NAME, null, 1);

        this.context=context;
        DB_PATH = context.getDatabasePath(DB_NAME).getPath();
        openDataBase();
        Log.d("Parh","ok "+DB_PATH);
        Log.d("Name",DB_NAME);

    }

    private SQLiteDatabase openDataBase() throws SQLException {
        String path=DB_PATH;
        if(database==null){
            createDataBase();
            database=SQLiteDatabase.openDatabase(path,null,SQLiteDatabase.OPEN_READONLY);
        }
        return database;
    }

    private void createDataBase() {
        boolean dbExist = checkDataBase();
        if (!dbExist) {
            this.getReadableDatabase();//Создает и/или открывает базу данных
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database!");
            }
        }
    }

    private void copyDataBase() throws IOException {
        // Открываем поток для чтения из уже созданной нами БД источник в assets
        InputStream externalDbStream = context.getAssets().open(DB_NAME);
        // Путь к уже созданной пустой базе в андроиде
        String outFileName = DB_PATH;
        // Теперь создадим поток для записи в эту БД побайтно
        OutputStream localDbStream = new FileOutputStream(outFileName);
        // Собственно, копирование
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = externalDbStream.read(buffer)) > 0) {
            localDbStream.write(buffer, 0, bytesRead);
        }
        // Мы будем хорошими мальчиками и закроем потоки
        localDbStream.close();
        externalDbStream.close();
    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDb = null;
        String path = DB_PATH;
        try {
            checkDb = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        } catch (SQLiteException e) {}
        //Андроид не любит утечки ресурсов, все должно закрываться
        if (checkDb != null) checkDb.close();
        return checkDb != null;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    @Override
    public synchronized void close() {
        if (database != null) {
            database.close();
        }
        super.close();
    }


    public Cursor gerData(int id_group){
        SQLiteDatabase SQL= this.getReadableDatabase();

        Cursor cursor;
        String table="record inner join lecturer on record.id_lecturer = lecturer.id_lecturer "+
                "inner join subject on record.id_subject = subject.id_subject "+
                "inner join subject_type on record.id_subject_type = subject_type.id "+
                "inner join classroom on record.id_classroom = classroom.id_classroom "+
                "inner join subject_for on record.id_subject_for = subject_for.id";
        String[] colums={"record.id_record","week_number","week_day","subj_ordinal_number",
                "lecturer.name_lecturer","subject.abname_subject",
                "subject_type.name as type_name","classroom.number","classroom.building","subject_for.name"};
        String selection="id_group = ?";
        String[] selectArgs={Integer.toString(id_group)};


        cursor=SQL.query(table,colums,selection,selectArgs,null,null,null);

        return cursor;
    }

}
