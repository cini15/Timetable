package by.bsac.timetable.resourc.model.date;

import android.util.Log;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class AppDate {
    private Calendar today;
    private int curretdWeek;
    private int dayOfWeek;

    public AppDate() {
       this.today=new GregorianCalendar();
       today.setFirstDayOfWeek(Calendar.MONDAY);
       calcNowDate();
    }

    private void calcNowDate(){

        this.dayOfWeek=today.get(Calendar.DAY_OF_WEEK)-1;

        int numberWeeks=today.get(Calendar.WEEK_OF_YEAR);
        Calendar firstSept=new GregorianCalendar(today.get(Calendar.YEAR),8,1);

        if(today.before(firstSept)) {
              firstSept.set(Calendar.YEAR,today.get(Calendar.YEAR)-1);
              Calendar lastNewYear=new GregorianCalendar(today.get(Calendar.YEAR)-1,Calendar.DECEMBER,31);
              numberWeeks+=lastNewYear.get(Calendar.WEEK_OF_YEAR)-firstSept.get(Calendar.WEEK_OF_YEAR);
        }else {
            numberWeeks-=firstSept.get(Calendar.WEEK_OF_YEAR);
        }

        curretdWeek=numberWeeks%4;
        Log.e("Appdate", "curretdWeek "+ String.valueOf(curretdWeek));

    }

    public Calendar getToday() {
        return today;
    }

    public int getCurretdWeek() {
        return curretdWeek;
    }

    public int getWeekDay() {
        return dayOfWeek;
    }
}
