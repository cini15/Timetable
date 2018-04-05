package by.bsac.timetable.resourc.records;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import by.bsac.timetable.R;

import java.util.ArrayList;


public class WeeksManager {
    private Week[] weeks;

    public WeeksManager() {
        this.weeks = new Week[4];
        weeks[0]=new Week();
        weeks[1]=new Week();
        weeks[2]=new Week();
        weeks[3]=new Week();
    }

    public Week getWeeks(int week) {
        return weeks[week];
    }

    public void InitializationManager(Cursor cursor) {


        if (cursor != null) {
            if (cursor.moveToFirst()) {

                do {
                    switch (cursor.getInt(cursor.getColumnIndex("week_number"))){
                        case 1:{
                            weeks[0].WeekInit(cursor);
                            break;
                        }
                        case 2:{
                            weeks[1].WeekInit(cursor);
                            break;
                        }
                        case 3:{
                            weeks[2].WeekInit(cursor);
                            break;
                        }
                        case 4:{
                            weeks[3].WeekInit(cursor);
                            break;
                        }
                        default:{
                            break;
                        }
                    }


                } while (cursor.moveToNext());
            }
        } //else
            //если курсор пуст

    }

    public void WriteWeek(int num_week, AppCompatActivity activity){
        weeks[num_week].WriteDays(activity);


    }


    public ArrayList<Record> getListRecordByWeekByDay(int num_week,int num_day){
        ArrayList<Record> list;
        list=weeks[num_week].getArrayListRecordByDay(num_day);

        return list;
    }


}
