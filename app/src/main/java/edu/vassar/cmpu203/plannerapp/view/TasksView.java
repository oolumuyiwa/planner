package edu.vassar.cmpu203.plannerapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import edu.vassar.cmpu203.plannerapp.controller.MainActivity;
import edu.vassar.cmpu203.plannerapp.databinding.FragmentTasksViewBinding;
import edu.vassar.cmpu203.plannerapp.model.Course;
import edu.vassar.cmpu203.plannerapp.model.Pair;
import edu.vassar.cmpu203.plannerapp.model.Task;

public class TasksView extends Fragment implements ITasksView{
    private FragmentTasksViewBinding binding;
    private ITasksView.Listener listener;
    public String allTasks;
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

    public static Bundle makeArgsBundle(String allTasks) {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("ALL TASKS", allTasks);
        return bundle;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = this.getArguments();
        if (args != null) {
            this.allTasks = args.getString("ALL TASKS");
        } else this.allTasks = "";
    }
    //@Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        MainActivity mainActivity = (MainActivity) getActivity();
        updateTaskDisplay(mainActivity.library.getTasks());
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

        this.binding.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.library.setAllTasks(new ArrayList<>());
                updateTaskDisplay(mainActivity.library.getTasks());
            }
        });

    }

    //@Override
    public View getRootView() {
        return null;
    }

    @Override
    public void updateTaskDisplay(List<Task> tasks) {
        String res = "";
        for (int i = 0; i < tasks.size(); i++){
            Task task = tasks.get(i);
            int holder = i + 1;
            res += holder + "." + "\n";
            res += "Name: " + task.name + "\n";
            if(task.associatedCourse == null) {
                res += "Course: none" + "\n";
            }
            else {
                res += "Course: " + task.associatedCourse.toString() + "\n";
            }
            res += task.type + "\n";
            if (task.notes.length() > 0){
                res += "Notes: " + task.notes + "\n";
            }
            LocalDateTime dateTime = task.deadline;
            if (dateTime.getYear() >= LocalDateTime.MAX.getYear()){
                res += "No deadline" + "\n";
            }
            else {
                res += "Due on: " + String.valueOf(dateTime.getHour()) + ":";
                if (dateTime.getMinute() < 10) {
                    res += "0" + dateTime.getMinute() + "\n";
                } else {
                    res += String.valueOf(dateTime.getMinute()) + "\n";
                }
                res += dateTime.getDayOfWeek().toString() + ", " + dateTime.getDayOfMonth() + " " + dateTime.getMonth().toString()
                        + " " + dateTime.getYear() + "\n";

            }


            res += "\n";
            res += "(----------------><-----------------)" + "\n";

        }
        this.binding.tasksList.setText(res);
    }


}
