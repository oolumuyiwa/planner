package edu.vassar.cmpu203.plannerapp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.plannerapp.R;
import edu.vassar.cmpu203.plannerapp.databinding.FragmentAddTaskViewBinding;
import edu.vassar.cmpu203.plannerapp.model.Task;


public class AddTaskView extends Fragment implements IAddTaskView {
    private FragmentAddTaskViewBinding binding;
    private IAddTaskView.Listener listener;

    public AddTaskView(Listener listener) {
        this.listener = listener;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // onCreateView is responsible for inflating the layout

        this.binding = FragmentAddTaskViewBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public View getRootView() {
        return null;
    }

    @Override
    public void updateTaskDisplay(Task task) {

    }
}