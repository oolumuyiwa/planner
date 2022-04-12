package edu.vassar.cmpu203.plannerapp.view;

import android.view.View;

import edu.vassar.cmpu203.plannerapp.model.Course;


public interface ICoursesView {
    /* interface for contract that listener to view events must fulfill. */
    interface Listener{
        void onAddCourse();
        void onClickCoursePane();}

    View getRootView();
    void updateCourseDisplay(Course course);
}
