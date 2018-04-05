package by.bsac.timetable.resourc.records;


import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import by.bsac.timetable.R;

import static android.view.Gravity.RIGHT;



public class Record {
    private boolean content;
    private int ordinal_number;
    private String subject;
    private String lecturer;
    private String type;
    private String subjectFor;
    private String timeBegin;

    private int numder;
    private int building;
    public Record(){
        this.content=false;
    }


    public boolean isContent() {
        return content;
    }

    public void setContent(boolean content) {
        this.content = content;
    }

    public int getOrdinal_number() {
        return ordinal_number;
    }

    public void setOrdinal_number(int ordinal_number) {
        this.ordinal_number = ordinal_number;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubjectFor() {
        return subjectFor;
    }

    public void setSubjectFor(String subjectFor) {
        this.subjectFor = subjectFor;
    }

    public String getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(String timeBegin) {
        this.timeBegin = timeBegin;
    }

    public int getNumder() {
        return numder;
    }

    public void setNumder(int numder) {
        this.numder = numder;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public Record CreatRecord(Cursor cursor){
        this.ordinal_number=cursor.getInt(cursor.getColumnIndex("subj_ordinal_number"));
        this.subject=cursor.getString(cursor.getColumnIndex("abname_subject"));
        this.lecturer=cursor.getString(cursor.getColumnIndex("name_lecturer"));
        this.type=cursor.getString(cursor.getColumnIndex("type_name"));
        this.subjectFor=cursor.getString(cursor.getColumnIndex("name"));
        this.numder=cursor.getInt(cursor.getColumnIndex("number"));
       // this.timeBegin=String.valueOf(this.ordinal_number);//исправить
        this.building=cursor.getInt(cursor.getColumnIndex("building"));
        this.timeBegin=String.valueOf(R.string.less1);
        this.content=true;
        return this;
    }




}
