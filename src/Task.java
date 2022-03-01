import java.util.Calendar;

class Task {
    public String name;
    public String type;
    public Course associatedCourse;
    public Calendar deadline;
    public String notes;
    public Task(String name, String type, Course associatedCourse, Calendar deadline, String notes){
        this.name = name;
        this.type = type;
        this.associatedCourse = associatedCourse;
        this.deadline = deadline;
        this.notes = notes;
    }
    public Task(){
        this.name = "";
        this.type = "";
    }
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

}