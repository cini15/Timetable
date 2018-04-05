package by.bsac.timetable;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import by.bsac.timetable.resourc.BDWorker;
import by.bsac.timetable.resourc.faculty.Facultets;
import by.bsac.timetable.resourc.faculty.Faculty;
import by.bsac.timetable.resourc.faculty.Group;
import by.bsac.timetable.resourc.faculty.Groups;

public class SelectGroup extends AppCompatActivity implements View.OnClickListener{

   private BDWorker bdWorker;
   private SQLiteDatabase db;
   private Facultets facultets;
   private Groups groups;
   private Spinner spin1,spin2;
   private Button button;
   private int val_group;
   private String val_NameGroup;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectgroup);
        
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        bdWorker = new BDWorker(this);
        db = bdWorker.getReadableDatabase();
        initFacult();
        spin1=(Spinner)findViewById(R.id.faculty);
        final ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,facultets.getAllNameFacultets());
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      //  spin1.setPrompt("Сделайте выбор.");
        spin1.setAdapter(adapter1);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int val_faculty;
                val_faculty = facultets.getFacultetByName(adapter1.getItem(i));
                initGroup(val_faculty);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button= (Button)findViewById(R.id.btnOkGroup);
        button.setOnClickListener(this);

    }

    private void initFacult() {

        Cursor cursor = db.query("faculty", null, null, null, null, null, null);
        facultets= new Facultets();
        if (cursor.moveToFirst()) {
            int id_facuity = cursor.getColumnIndex("id_faculty");
            int name_faculty = cursor.getColumnIndex("name_faculty");
            do {
                Faculty faculty = new Faculty();
                faculty.setId_faculty(cursor.getInt(id_facuity));
                faculty.setName_faculty(cursor.getString(name_faculty));
                facultets.setFacultets(faculty);

            } while (cursor.moveToNext());
        }
     cursor.close();
    }

    private void initGroup(int id_Faculty){

        Cursor cursor = db.query("'group'",
                new String[] {"id_group","name_group","id_faculty"} , "id_faculty = ?",
                new String[] {Integer.toString(id_Faculty)}, null, null, null);
        groups= new Groups();
        if (cursor.moveToFirst()) {
            int id_group = cursor.getColumnIndex("id_group");
            int name_group = cursor.getColumnIndex("name_group");
            int id_faculty = cursor.getColumnIndex("id_faculty");
            do {
                Group group = new Group();
                group.setId_group(cursor.getInt(id_group));
                group.setName_group(cursor.getString(name_group));
                group.setId_facuily(cursor.getInt(id_faculty));
                groups.setGroups(group);

            } while (cursor.moveToNext());
        }
        cursor.close();

        spin2=(Spinner)findViewById(R.id.group);
        final ArrayAdapter adapter= new ArrayAdapter(this,android.R.layout.simple_spinner_item,groups.getAllNameGroups());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(adapter);
        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                val_NameGroup=(String) adapter.getItem(i);
                val_group=groups.getGroupByName(val_NameGroup);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnOkGroup:{
                sharedPreferences=getSharedPreferences("APP_PREFF", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putInt("id_group",val_group);
                editor.putString("name_group",val_NameGroup);

                editor.apply();

                this.finish();
                break;
            }

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                return true;
            }
            default:return super.onOptionsItemSelected(item);
        }
    }
}
