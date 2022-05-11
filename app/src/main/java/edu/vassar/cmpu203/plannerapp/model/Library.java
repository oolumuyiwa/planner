package edu.vassar.cmpu203.plannerapp.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Library implements Serializable {
    //allows for new courses/tasks to be added to an array
    private List<Course> allCourses = new ArrayList<>();
    private List<Task> allTasks = new ArrayList<>();

public Library(List<Course> allCourses, List<Task> allTasks){
    this.allCourses = allCourses;
    this.allTasks = allTasks;
}

public Library(){}
    public List<Course> addAndUpdateCourses(Course course){
    allCourses.add(course);
    return allCourses;
    }
    public List<Task> addAndUpdateTasks(Task task){
    allTasks.add(task);
    return allTasks;
    }
    public List<Course> getCourses() {
        return allCourses;
    }
    public List<Task> getTasks() {
        return allTasks;
    }
    public String courseDescription(List<Course> courses){
                String res = "";
        for (int i = 0; i < courses.size(); i++){
            Course course = courses.get(i);
            int holder = i + 1;
            res += holder + "." + "\n";
            res += "Name: " + course.name + "\n";
            res += "Code: " + course.code + "\n";
            res += "Semester: " + course.semester.toString() + "\n";
            res += "Room: " + course.room + "\n";
            if (course.notes.length() > 0){
                res += "Notes: " + course.notes + "\n";
            }
            Pair<LocalDateTime, LocalDateTime> dateTime = course.meetingTimes.get(0);
            res += String.valueOf(dateTime.getLeft().getHour()) + ":";
            if(dateTime.getLeft().getMinute() < 10){
                res += "0" + dateTime.getLeft().getMinute() + " - ";
            }
            else{
                res += String.valueOf(dateTime.getLeft().getMinute()) + " - ";
            }
            res += String.valueOf(dateTime.getRight().getHour()) + ":";
            if(dateTime.getRight().getMinute() < 10){
                res += "0" + dateTime.getRight().getMinute() + "\n";
            }
            else{
                res += String.valueOf(dateTime.getRight().getMinute()) + "\n";
            }



            for(int j = 0; j < course.meetingTimes.size(); j++){
                res += course.meetingTimes.get(j).getLeft().getDayOfWeek() + ". ";
            }
            res += "\n";
            res += "----------------><-----------------" + "\n";

        }
        return res;
    }

    public String taskDescription(List<Task> tasks){
        String res = "";
        for (int i = 0; i < tasks.size(); i++){
            Task task = tasks.get(i);
            int holder = i + 1;
            res += holder + "." + "\n";
            res += "Name: " + task.name + "\n";
            if(task.associatedCourse == null) {
                res += "Course: none" + "\n";
            }
            else {
                res += "Course: " + task.associatedCourse.toString() + "\n";
            }
            res += task.type + "\n";
            if (task.notes.length() > 0){
                res += "Notes: " + task.notes + "\n";
            }
            LocalDateTime dateTime = task.deadline;
            if (dateTime.getYear() >= LocalDateTime.MAX.getYear()){
                res += "No deadline" + "\n";
            }
            else {
                res += "Due on: " + String.valueOf(dateTime.getHour()) + ":";
                if (dateTime.getMinute() < 10) {
                    res += "0" + dateTime.getMinute() + "\n";
                } else {
                    res += String.valueOf(dateTime.getMinute()) + "\n";
                }
                res += dateTime.getDayOfWeek().toString() + ", " + dateTime.getDayOfMonth() + " " + dateTime.getMonth().toString()
                        + " " + dateTime.getYear() + "\n";

            }


            res += "\n";
            res += "(----------------><-----------------)" + "\n";

        }
        return res;
    }

}
