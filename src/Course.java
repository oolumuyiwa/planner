import java.util.Calendar;

public class Course {
    public String name;
    public int code;
    public Semester semester;
    public Calendar meetingTime;

    public Course(String name, int code, Semester semester, Calendar meetingTime) {
        this.name = name;
        this.code = code;
        this.semester = semester;
        this.meetingTime = meetingTime;
    }

    public void setMeetingTime(String day, int time) {

        if (day.equalsIgnoreCase("Mon")) {

        } else if (day.equalsIgnoreCase("Tue")) {

        }
        else if (day.equalsIgnoreCase("Wed")) {

        }
        else if (day.equalsIgnoreCase("Thu")) {

        }
        else if (day.equalsIgnoreCase("Fri")) {

        }
        else if (day.equalsIgnoreCase("Sat")) {

        }
        else if (day.equalsIgnoreCase("Sun")) {

        }

    }
}