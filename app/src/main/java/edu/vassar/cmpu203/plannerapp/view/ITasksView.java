package edu.vassar.cmpu203.plannerapp.view;

import android.view.View;

import java.util.List;

import edu.vassar.cmpu203.plannerapp.model.Task;

public interface ITasksView {
    /* interface for contract that listener to view events must fulfill. */
    interface Listener{
        void onAddTask();
        void onClickTaskPane();}

    View getRootView();
    void updateTaskDisplay(List<Task> tasks);
}
