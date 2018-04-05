package by.bsac.timetable.resourc.records;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class Day {
    private int week_day;
    private ArrayList<Record> records;

    public Day(){
        records=new ArrayList<>();

    }

    public int getWeek_day() {
        return week_day;
    }

    public void InitDay(Cursor cursor){
        this.week_day=cursor.getInt(cursor.getColumnIndex("week_day"));
        Record record = new Record();
        record.CreatRecord(cursor);
        records.add(record);
    }

    public void WriteDay(AppCompatActivity activity){
        for (int i = 0; i <records.size() ; i++) {
   //         records.get(i).WriteRecord(week_day,activity);

        }

    }

    public ArrayList<Record> getArrayListRecord(){


        return records;
    }
}
