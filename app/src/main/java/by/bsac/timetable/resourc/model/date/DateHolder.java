package by.bsac.timetable.resourc.model.date;

public class DateHolder {
    private static DateHolder instans;
    private AppDate appDate;

    public DateHolder() {
        this.appDate = new AppDate();
    }

    public static DateHolder getInstans(){
        if (instans==null)
           instans = new DateHolder();

        return instans;
    }

    public AppDate getAppDate() {
        return appDate;
    }
}
