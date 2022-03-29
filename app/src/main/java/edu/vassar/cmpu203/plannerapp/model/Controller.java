package edu.vassar.cmpu203.plannerapp.model;

//TODO might want to comment out/remove packages that are unneeded (in other classes too)
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

    public static ArrayList<Task> tasks = new ArrayList<>();
    public static ArrayList<Course> courses = new ArrayList<>();

    public static void main(String[] args) {

        //Print welcome message and a few instructions on using the app
        System.out.println("Welcome to Aaron and Tomiwa's Planner App");
        while (true) {
            System.out.println("To add a task, Please enter 'New Task' ");
            System.out.println("To add a course, please enter 'New Course' ");
            System.out.println("Enter 'All Tasks' to see all your added tasks");
            System.out.println("Enter 'All Courses' to see your added courses");
            System.out.println("To edit a course, please enter 'Edit Course'");
            System.out.println("To edit a course, please enter 'Edit Task'");
            System.out.println("Enter QUIT to exit the program");

            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine().toLowerCase();

            if (command.toLowerCase().compareTo("new task") == 0) {
                addTask();
                System.out.println("Task successfully added");
            } else if (command.toLowerCase().compareTo("new course") == 0) {
                addCourse();
                System.out.println("Course successfully added");
            } else if (command.toLowerCase().compareTo("all courses") == 0) {
                listCourses();
            } else if (command.toLowerCase().compareTo("all tasks") == 0) {
                listTasks();
            } else if (command.toLowerCase().compareTo("edit course") == 0) {

                System.out.println("Enter the code of the course you want to edit");
                int i = 0;

                for (Course course : courses) {
                    if (course.code == Integer.parseInt(scanner.nextLine())) {
                        editCourse(course);
                        i++;
                    }
                }

                if(i == 0){
                    System.out.println("No course found with code");
                } else{
                    System.out.println("Course successfully edited");
                }
            } else if (command.toLowerCase().compareTo("edit task") == 0){

                System.out.println("Enter the id of the task you want to edit");
                String sinput = scanner.nextLine();
                int i = 0;

                for (Task t : tasks) {
                    if (t.id == Integer.parseInt(sinput)){
                        editTask(t);
                        i++;
                    }
                }

                if(i == 0){
                    System.out.println("No task found with id");
                } else{
                    System.out.println("Task successfully edited");
                }
            } else if (command.toLowerCase().compareTo("quit") == 0) {
                System.out.println("Thank you for using the planner app.");
                break;
            } else{
                System.out.println("Invalid input. Please enter any of the valid commands.");
            }
        }
    }

    public static void addCourse() {

        Scanner scanner = new Scanner(System.in);
        Course newCourse = new Course();

        System.out.println("Enter course name");
        newCourse.name = scanner.nextLine();

        //TODO throws exception if not a number
        System.out.println("Enter course code");
        newCourse.code = Integer.parseInt(scanner.nextLine());

        //TODO Exception in thread "main" java.util.NoSuchElementException
        System.out.println("Enter course semester");
        String st = scanner.nextLine().toUpperCase();
        Scanner stinput = new Scanner(st);
        newCourse.semester = new Semester(stinput.next(), stinput.nextInt());

        while (true) {
            //TODO, string too long for proper output displaying, might want to shorten or add newlines
            System.out.println("Enter the meeting times with the number of recurrences for each meeting time for your course with space-seperated input in the manner specified in the following examples: Tue 13:00-13:50 10, Mon 08:00-15:00 5. If there's none enter 'none'. If you are done adding the meeting times enter 'done'.");
            String str = scanner.nextLine();

            if (str.toLowerCase().compareTo("none") == 0) {
                break;
            }
            if (str.toLowerCase().compareTo("done") == 0) {
                break;
            }
            try {
                String name = str.substring(0, 3);
                String time = str.substring(4, 15);
                int recurrences = Integer.parseInt(str.substring(16));
                newCourse.setMeetingTime(name, time, recurrences);
            } catch (Exception e){
                System.out.println("Invalid input. Please try again.");
            }
        }
        courses.add(newCourse);
    }

    public static void addTask(){

        Scanner scanner = new Scanner(System.in);
        Task newTask = new Task();

        System.out.println("Enter task name");
        newTask.name = scanner.nextLine();

        System.out.println("Enter task type");
        newTask.type = scanner.nextLine();

        System.out.println("Enter deadline in yyyy-mm-dd hh:mm format, or enter 'no deadline' if there isn't one");
        String str = scanner.nextLine();

        //TODO Exception in thread "main" java.time.format.DateTimeParseException
        if (str.toLowerCase().compareTo("no deadline") == 0){
            newTask.deadline = null;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            newTask.deadline = LocalDateTime.parse(str, formatter);
        } catch (InputMismatchException e){
            System.out.println("Invalid input. Please refer to instructions and try again.");
        }


        System.out.println("Enter the code of associated course for this task or 'none' if it's not associated with any course");
        String st = scanner.nextLine();

        if (st.toLowerCase().compareTo("none") == 0){
            newTask.associatedCourse = null;
        }

        for (Course course : courses){
            if (course.code  == Integer.parseInt(st)){
                course.tasks.add(newTask);
                newTask.associatedCourse = course;
            }
        }

        System.out.println("Enter any notes on the task you're adding or 'none' if that's all.");
        newTask.notes = scanner.nextLine();
        tasks.add(newTask);
    }

    public static void listCourses(){

        if (courses.size() == 0){
            System.out.println("No courses in the system :( \n");
        } else{
            for (int i = 0; i < courses.size(); i++){
                System.out.println(courses.get(i).toString() +"\n");
            }
        }
    }

    public static void listTasks(){
        if (tasks.size() == 0){
            System.out.println("No tasks in the system :( \n");
        } else{
            for (int i = 0; i < tasks.size(); i++){
                System.out.println(tasks.get(i).toString() + "\n");
            }
        }
    }

    public static void editCourse(Course c) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Enter the component of" + c.name + " " + c.code +  " you want to edit: 'name', 'code', 'task', or 'semester'. Enter 'done' if you're done editing.");
            String st = scanner.nextLine();

            if (st.toLowerCase().compareTo("done") == 0) {
                break;
            } else if (st.toLowerCase().compareTo("name") == 0) {
                System.out.println("Enter new course name");
                c.setName(scanner.nextLine());
            } else if (st.toLowerCase().compareTo("code") == 0) {
                System.out.println("Enter new course code");
                c.setCode(Integer.parseInt(scanner.nextLine()));
            } else if (st.toLowerCase().compareTo("semester") == 0) {
                System.out.println("Enter new course semester");
                Semester newsem = new Semester(scanner.next(), scanner.nextInt());
                c.setSemester(newsem);
            } else if (st.toLowerCase().compareTo("task") == 0) {

                System.out.println("Enter the ID of the task you want to edit");
                int tID = Integer.parseInt(scanner.nextLine());
                int i = 0;

                for (Task task : c.tasks) {
                    //String taskName = task.name.toLowerCase();
                    if (tID == task.id) {
                        editTask(task);
                    }
                    i++;
                }
                if (i == 0) {
                    System.out.println("No task found with name.");
                }
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public static void editTask(Task t){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the component you want to edit of the" + t.name + " " + t.type + " with id "+ t.id + ": 'name', 'type', 'course', 'notes' or 'deadline'. Enter 'done' if you're done editing.");
        String st = scanner.nextLine();

        if (st.toLowerCase().compareTo("name") == 0) {
            System.out.println("Enter new task name");
            t.setName(scanner.nextLine());
        } else if (st.toLowerCase().compareTo("code") == 0) {
            System.out.println("Enter new task type");
            t.setType(scanner.nextLine());
        } else if (st.toLowerCase().compareTo("notes") == 0) {
            System.out.println("Enter new course semester");
            t.setNotes(scanner.nextLine());
        } else if (st.toLowerCase().compareTo("course") == 0){
            System.out.println("Enter code of new associated course if there's one or 'none' if there's none.");
            String s = scanner.nextLine();
            if(s.toLowerCase().compareTo("none") == 0){
                t.setAssociatedCourse(null);
            }
            for (Course c : courses){
                if(c.code == Integer.parseInt(s)){
                    t.setAssociatedCourse(c);
                }
            }
        } else if(st.toLowerCase().compareTo("deadline") == 0){

            System.out.println("Enter the new deadline in yyyy-mm-dd hh:mm format, or enter 'no deadline' if there isn't one");
            String str = scanner.nextLine();

            if (str.toLowerCase().compareTo("no deadline") == 0){
                t.setDeadline(null);
            }

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                t.setDeadline(LocalDateTime.parse(str, formatter));
            } catch (InputMismatchException e){
                System.out.println("Invalid input. Please refer to instructions and try again.");
            }

        } else {
            System.out.println("Invalid input. Try again.");
        }
    }

    /*
    ITERATION 2 ROUGH WORKINGS:
    public static void editCourse(Course c) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the course component you want to edit: 'name', 'code', 'meeting times', 'task', or 'semester'. Enter 'done' if you're done editing.");
            String st = scanner.nextLine();
            if (st.toLowerCase().compareTo("done") == 0){
                break;
            }
            else if (st.toLowerCase().compareTo("name") == 0) {
                System.out.println("Enter new course name");
                c.setName(scanner.nextLine());

            } else if (st.toLowerCase().compareTo("code") == 0) {
                System.out.println("Enter new course code");
                c.setCode(Integer.parseInt(scanner.nextLine()));

            } else if (st.toLowerCase().compareTo("semester") == 0) {
                System.out.println("Enter new course semester");
                Semester newsem = new Semester(scanner.next(), scanner.nextInt());
                c.setSemester(newsem);

            } else if (st.toLowerCase().compareTo("task") == 0) {
                System.out.println("Enter the name of the task you want to edit");
                String tName = scanner.nextLine();
                int i = 0;
                for (Task task : c.tasks) {
                    String taskName = task.name.toLowerCase();
                    if (tName.toLowerCase().compareTo(taskName) == 0) {
                        editTask(task);
                    }
                    i++;
                }
                if (i == 0) {
                    System.out.println("No task found with name.");
                }

            }
            else if (st.toLowerCase().compareTo("meeting times") == 0) {
                System.out.println("Enter the meeting time you want removed with the number of recurrences for your course with space-seperated input in the manner specified in the following examples: Tue 13:00-13:50 10, Mon 08:00-15:00 5. ");
            try {
                String str = scanner.nextLine();
                if (str.toLowerCase().compareTo("done") == 0) {

                }
                String name = str.substring(0, 3);
                String time = str.substring(4, 15);
                int recurrences = Integer.parseInt(str.substring(16));
                c.removeMeetingTime(name, time, recurrences);
            }catch (Exception e){
                System.out.println("Invalid input. Please try again.");
            }

            }
            else{
                System.out.println("Invalid input. Please try again.");
            }

        }
    }

 */

}