package edu.vassar.cmpu203.plannerapp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import edu.vassar.cmpu203.plannerapp.R;
import edu.vassar.cmpu203.plannerapp.controller.MainActivity;
import edu.vassar.cmpu203.plannerapp.databinding.FragmentCoursesViewBinding;

import edu.vassar.cmpu203.plannerapp.databinding.FragmentTasksViewBinding;
import edu.vassar.cmpu203.plannerapp.model.Course;
import edu.vassar.cmpu203.plannerapp.model.Pair;


public class CoursesView extends Fragment implements ICoursesView{
    private FragmentCoursesViewBinding binding;
    private ICoursesView.Listener listener;

    public CoursesView(ICoursesView.Listener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // onCreateView is responsible for inflating the layout
        this.binding = FragmentCoursesViewBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        this.binding.addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CoursesView.this.listener.onAddCourse();
            }
        });
        this.binding.paneName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CoursesView.this.listener.onClickCoursePane();
            }
        });
    }

    @Override
    public View getRootView() {
        return null;
    }

    @Override
    public void updateCourseDisplay(Course course) {

        RecyclerView rvCourses = (RecyclerView) getView().findViewById(R.id.coursesRecyclerView);
        List<Course> courses = MainActivity.allCourses;
        CoursesAdapter adapter = new CoursesAdapter(courses);
        rvCourses.setAdapter(adapter);
        rvCourses.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}