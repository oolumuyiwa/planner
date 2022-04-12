package edu.vassar.cmpu203.plannerapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import edu.vassar.cmpu203.plannerapp.databinding.FragmentTasksViewBinding;
import edu.vassar.cmpu203.plannerapp.model.Task;

public class TasksView extends Fragment implements ITasksView{
    private FragmentTasksViewBinding binding;
    private ITasksView.Listener listener;

    public TasksView(ITasksView.Listener listener) {
        this.listener = listener;
    }

    //@Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // onCreateView is responsible for inflating the layout

        this.binding = FragmentTasksViewBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    //@Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        this.binding.addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        TasksView.this.listener.onAddTask();
                    }
                });

        this.binding.paneName.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                TasksView.this.listener.onClickTaskPane();
                binding.paneName.setText("COURSES");
            }
        });

    }

    //@Override
    public View getRootView() {
        return null;
    }

    //@Override
    public void updateTaskDisplay(Task task) {

    }
}
