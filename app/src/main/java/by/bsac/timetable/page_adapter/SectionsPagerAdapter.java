package by.bsac.timetable.page_adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import by.bsac.timetable.resourc.records.Record;
import by.bsac.timetable.resourc.records.Week;
import java.util.ArrayList;


public class SectionsPagerAdapter extends android.support.v4.app.FragmentStatePagerAdapter  {
    private final int count = 6;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    private Week week;

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    @Override
    public Fragment getItem(int position) {

        HolderFragment fragment = new HolderFragment();
        ArrayList<Record> list = this.week.getArrayListRecordByDay(position + 1);
        fragment.setList(list);

        return fragment;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Понедельник";
            case 1:
                return "Вторник";
            case 2:
                return "Среда";
            case 3:
                return "Четверг";
            case 4:
                return "Пятница";
            case 5:
                return "Суббота";
        }
        return null;
    }

    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
