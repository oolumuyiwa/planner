package edu.vassar.cmpu203.plannerapp.view;

import android.view.View;

import edu.vassar.cmpu203.plannerapp.databinding.ActivityMainBinding;
import edu.vassar.cmpu203.plannerapp.model.Task;

public class TasksView implements ITasksView{
    private ActivityMainBinding binding;
    private Listener listener;
    @Override
    public View getRootView() {
        return null;
    }

    @Override
    public void updateTaskDisplay(Task task) {

    }
}
