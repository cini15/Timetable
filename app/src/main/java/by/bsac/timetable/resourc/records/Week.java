package by.bsac.timetable.resourc.records;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class Week {
    private List<Day> days;

    public Week() {
        this.days = new ArrayList<Day>();
    }

    public void WeekInit(Cursor cursor) {

        int week_day = cursor.getInt(cursor.getColumnIndex("week_day"));

        if (days.size()!=0) {
            for (int i = 0; i <days.size(); i++) {
                if(days.get(i).getWeek_day()==week_day)
                    days.get(i).InitDay(cursor);

            }
        } else {
            Day day = new Day();
            day.InitDay(cursor);
            days.add(day);
        }
    }

    public void WriteDays(AppCompatActivity activity) {

        for (int i = 0; i < days.size(); i++) {
            Day day = days.get(i);
            day.WriteDay(activity);
        }

    }

    public ArrayList<Record> getArrayListRecordByDay(int num_day) {
        ArrayList<Record> list = null;
        for (int i = 0; i < days.size(); i++) {

            if (days.get(i).getWeek_day() == num_day) {

                list = days.get(i).getArrayListRecord();
                break;
            }

        }


        return list;

    }

}
