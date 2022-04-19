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

public class MainActivity extends AppCompatActivity
        implements ITasksView.Listener, IAddTaskView.Listener, IAddCourseView.Listener, ICoursesView.Listener{

    // keeps track of the main view
    private IMainView mainView;

    //allows for new courses/tasks to be added to an array
    private List<Course> allCourses = new ArrayList<>();
    private List<Task> allTasks = new ArrayList<>();

    public List<Course> getCourses() {
        return allCourses;
    }
    public List<Task> getTasks() {
        return allTasks;
    }

    @Override
    //creates the first view that the user sees on app open after refresh
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.mainView = new MainView(this);
        setContentView(this.mainView.getRootView());
        this.mainView.displayFragment(new TasksView(this), true);
    }


    @Override
    //returns to TaskView
    public void onAddTaskDone(Task task) {

        String allC2String = String.valueOf(allTasks);
        Bundle argsBundle = TasksView.makeArgsBundle(allC2String);
        this.mainView.displayFragment(new TasksView(this), true);
    }

    @Override
    //adds created task to array of allTasks
    public void onAddedTask(Task task) {
        allTasks.add(task);
    }

    @Override
    //activates on add button click, opens up AddTaskView screen
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