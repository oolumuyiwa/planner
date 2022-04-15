package edu.vassar.cmpu203.plannerapp.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import edu.vassar.cmpu203.plannerapp.R;
import edu.vassar.cmpu203.plannerapp.model.Course;
import edu.vassar.cmpu203.plannerapp.view.*;

public class MainActivity extends AppCompatActivity implements ITasksView.Listener, IAddTaskView.Listener, IAddCourseView.Listener, ICoursesView.Listener {

    private IMainView mainView;  // keeps track of the main view
    public static ArrayList<Course> allCourses = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // create main view and set content to be its root view
        this.mainView = new MainView(this);
        setContentView(this.mainView.getRootView());

        this.mainView.displayFragment(new TasksView(this), true);

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
    public void onAddCourse() {
        this.mainView.displayFragment(new AddCourseView(this), true);
    }

    @Override
    public void onAddCourseDone(Course course, ICoursesView coursesView) {

        this.mainView.displayFragment(new CoursesView(this), true);
    }


//    @Override
    public void onAddCourseDone(Course course) {

    }

    @Override
    public void onClickCoursePane() {
        this.mainView.displayFragment(new TasksView(this), true);
    }
}