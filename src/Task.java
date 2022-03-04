import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

class Task {
    public String name;
    public String type;
    public Course associatedCourse;
    public LocalDateTime deadline;
    public String notes;

    public Task(String name, String type, Course associatedCourse, LocalDateTime deadline, String notes) {
        this.name = name;
        this.type = type;
        this.associatedCourse = associatedCourse;
        this.deadline = deadline;
        this.notes = notes;
    }

    public Task() {
        this.name = "Untitled";
        this.type = "Not given";
        this.associatedCourse = null;
        this.deadline = null;
        this.notes = "none";
    }

    public void setName(String name){
        this.name = name;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setNotes(String notes){
        this.notes = notes;
    }

    public void setAssociatedCourse(Course associatedCourse) {
        this.associatedCourse = associatedCourse;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public String toString() {
        String res = "";
        String deadlineMinute = "" + deadline.getMinute();
        if (deadline.getMinute() < 10) {
            deadlineMinute = "0" + deadline.getMinute();
        }
        String deadlineHour = "" + deadline.getHour();
        if (deadline.getHour() < 10) {
            deadlineHour = "0" + deadline.getHour();
        }
        res += "Task name: " + name + "\n";
        res += "Task type: " + type + "\n";
        if (associatedCourse == null) {
            res += "Associated course: none" + "\n";
        } else {
            res += "Associated course: " + associatedCourse.name + " " + associatedCourse.code + ", " + associatedCourse.semester.toString() + "\n";
        }
        if (deadline == null) {
            res += "Associated deadline: none" + "\n";
        }
        else {
            res += "Task deadline: " + deadline.getDayOfWeek() + ", " + deadline.getDayOfMonth() + " " + deadline.getMonth() + " " + deadline.getYear() + " at"
                    + deadlineHour + ":" + deadlineMinute;
        }
        res += "Task notes: " + notes + "\n";
        return res;
    }
}