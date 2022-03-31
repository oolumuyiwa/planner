package edu.vassar.cmpu203.plannerapp.view;

import android.view.View;

import edu.vassar.cmpu203.plannerapp.model.Task;

public interface ITasksView {
    /* interface for contract that listener to view events must fulfill. */
    interface Listener{ void onAddedItem(String name, int qty); }

    View getRootView();
    void updateTaskDisplay(Task task);
}
