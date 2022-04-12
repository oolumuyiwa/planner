package edu.vassar.cmpu203.plannerapp.view;

import android.view.View;

import edu.vassar.cmpu203.plannerapp.model.Course;
import edu.vassar.cmpu203.plannerapp.model.Task;

public interface IAddCourseView {
    interface Listener{
        void onAddCourse(); }


    View getRootView();
    void updateCourseDisplay(Course course);
}
