package edu.vassar.cmpu203.plannerapp.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//import android.util.Pair;
import android.view.View;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import edu.vassar.cmpu203.plannerapp.R;
import edu.vassar.cmpu203.plannerapp.model.Pair;
import edu.vassar.cmpu203.plannerapp.model.Course;
import edu.vassar.cmpu203.plannerapp.model.Semester;
import edu.vassar.cmpu203.plannerapp.model.Task;
import edu.vassar.cmpu203.plannerapp.view.*;

public class MainActivity extends AppCompatActivity implements ITasksView.Listener, IAddTaskView.Listener, IAddCourseView.Listener, ICoursesView.Listener{

    private IMainView mainView;  // keeps track of the main view
//    public ArrayList<Pair<LocalDateTime, LocalDateTime>> holderArrayList = new ArrayList<>();
//    public Course holder = new Course("Holder", "HOL 102", new Semester("Summer", 2020), "Notes", "Room",  holderArrayList);
    private List<Course> allCourses = new ArrayList<>();
    private List<Task> allTasks = new ArrayList<>();

    public List<Course> getCourses() {
        return allCourses;
    }
    public List<Task> getTasks() {
        return allTasks;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mainView = new MainView(this);
        setContentView(this.mainView.getRootView());

        this.mainView.displayFragment(new TasksView(this), true);

    }


    @Override
    public void onAddTaskDone(Task task) {
        String allC2String = String.valueOf(allTasks);
        Bundle argsBundle = TasksView.makeArgsBundle(allC2String);
        this.mainView.displayFragment(new TasksView(this), true);
    }

    @Override
    public void onAddTaskDone() {

    }

    @Override
    public void onAddedTask(Task task) {
        allTasks.add(task);
    }

    @Override
    public void onAddTask() {
        this.mainView.displayFragment(new AddTaskView(this), true);
    }

    @Override
    public void onClickTaskPane() {
        this.mainView.displayFragment(new CoursesView(this), true);
    }


    @Override
    public void onAddedCourse(Course course) {
        allCourses.add(course);
    }

    @Override
    public void onAddCourseDone(Course course) {
        //coursesView.updateCourseDisplay(MainActivity.allCourses);
        String allC2String = String.valueOf(allCourses);
        Bundle argsBundle = CoursesView.makeArgsBundle(allC2String);
        this.mainView.displayFragment(new CoursesView(this), true);

    }


    @Override
    public void onAddCourse() {
        this.mainView.displayFragment(new AddCourseView(this), true);
    }

    @Override
    public void onClickCoursePane() {
        this.mainView.displayFragment(new TasksView(this), true);
    }


}