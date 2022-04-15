package edu.vassar.cmpu203.plannerapp.view;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.time.LocalDateTime;
import java.util.List;

import edu.vassar.cmpu203.plannerapp.R;
import edu.vassar.cmpu203.plannerapp.controller.MainActivity;
import edu.vassar.cmpu203.plannerapp.databinding.FragmentCoursesViewBinding;

import edu.vassar.cmpu203.plannerapp.model.Course;
import edu.vassar.cmpu203.plannerapp.model.Pair;


public class CoursesView extends Fragment implements ICoursesView {
    private FragmentCoursesViewBinding binding;
    private ICoursesView.Listener listener;
    private static CoursesView instance = null;
    public String allCourses;


    public CoursesView(ICoursesView.Listener listener) {
        this.listener = listener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = this.getArguments();
        if (args != null) {
            this.allCourses = args.getString("ALL COURSES");
        } else this.allCourses = "";
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // onCreateView is responsible for inflating the layout
        this.binding = FragmentCoursesViewBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    public static CoursesView getInstance() {
        return instance;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        MainActivity mainActivity = (MainActivity) getActivity();
        updateCourseDisplay(mainActivity.getCourses());
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


    public static Bundle makeArgsBundle(String allCourses) {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("ALL COURSES", allCourses);
        return bundle;
    }

    @Override
    public void updateCourseDisplay(List<Course> courses) {
        String res = "";
        for (int i = 0; i < courses.size(); i++){
            Course course = courses.get(i);
            int holder = i + 1;
            res += holder + "." + "\n";
            res += "Name: " + course.name + "\n";
            res += "Code: " + course.code + "\n";
            res += "Semester: " + course.semester.toString() + "\n";
            res += "Room: " + course.room + "\n";
            if (course.notes.length() > 0){
                res += "Notes: " + course.notes + "\n";
            }
            Pair<LocalDateTime, LocalDateTime> dateTime = course.meetingTimes.get(0);
            res += String.valueOf(dateTime.getLeft().getHour()) + ":";
            if(dateTime.getLeft().getMinute() < 10){
                res += "0" + dateTime.getLeft().getMinute() + " - ";
            }
            else{
                res += String.valueOf(dateTime.getLeft().getMinute()) + " - ";
            }
            res += String.valueOf(dateTime.getRight().getHour()) + ":";
            if(dateTime.getRight().getMinute() < 10){
                res += "0" + dateTime.getRight().getMinute() + "\n";
            }
            else{
                res += String.valueOf(dateTime.getRight().getMinute()) + "\n";
            }



            for(int j = 0; j < course.meetingTimes.size(); j++){
                res += course.meetingTimes.get(j).getLeft().getDayOfWeek() + ". ";
            }
            res += "\n";
            res += "----------------><-----------------" + "\n";

        }
        this.binding.coursesList.setText(res);




//        ArrayAdapter<Course> courseArrayAdapter =
//                new ArrayAdapter<Course>(getContext(), android.R.layout.simple_list_item_1, mainActivity.getCourses());
//        // Set The Adapter
//        coursesList.setAdapter(courseArrayAdapter);

    }
}