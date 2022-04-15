package edu.vassar.cmpu203.plannerapp.view;

import android.view.View;

import java.util.List;

import edu.vassar.cmpu203.plannerapp.model.Course;


public interface ICoursesView {
    /* interface for contract that listener to view events must fulfill. */
    interface Listener{
        void onAddCourse();
        void onClickCoursePane();}

    View getRootView();
    void updateCourseDisplay(List<Course> course);
}
