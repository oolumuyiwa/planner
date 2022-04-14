package edu.vassar.cmpu203.plannerapp.view;

import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import edu.vassar.cmpu203.plannerapp.R;
import edu.vassar.cmpu203.plannerapp.databinding.FragmentAddCourseViewBinding;
import edu.vassar.cmpu203.plannerapp.databinding.FragmentAddTaskViewBinding;
import edu.vassar.cmpu203.plannerapp.databinding.FragmentCoursesViewBinding;
import edu.vassar.cmpu203.plannerapp.model.Course;
import edu.vassar.cmpu203.plannerapp.model.Pair;
import edu.vassar.cmpu203.plannerapp.model.Semester;


public class AddCourseView extends Fragment implements IAddCourseView{

    private FragmentAddCourseViewBinding binding;
    private IAddCourseView.Listener listener;

    public AddCourseView(Listener listener) {
        this.listener = listener;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // onCreateView is responsible for inflating the layout

        this.binding = FragmentAddCourseViewBinding.inflate(inflater);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Spinner spinner = (Spinner) getView().findViewById(R.id.courseSemesterSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.semesters_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                //Change the selected item's text color
                ((TextView) view).setTextColor(binding.createCourseDisplay.getTextColors());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });

        Switch noMeetingTime = (Switch)  getView().findViewById(R.id.noMeetingTime);


        noMeetingTime.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    getView().findViewById(R.id.meetingDaysDisplay).setVisibility(View.GONE);
                    getView().findViewById(R.id.sundayBtn).setVisibility(View.GONE);
                    getView().findViewById(R.id.mondayBtn).setVisibility(View.GONE);
                    getView().findViewById(R.id.tuesdayBtn).setVisibility(View.GONE);
                    getView().findViewById(R.id.wednesdayBtn).setVisibility(View.GONE);
                    getView().findViewById(R.id.thursdayBtn).setVisibility(View.GONE);
                    getView().findViewById(R.id.fridayBtn).setVisibility(View.GONE);
                    getView().findViewById(R.id.saturdayBtn).setVisibility(View.GONE);
                    getView().findViewById(R.id.startTimeDisplay).setVisibility(View.GONE);
                    getView().findViewById(R.id.startTime).setVisibility(View.GONE);
                    getView().findViewById(R.id.endTime).setVisibility(View.GONE);
                    getView().findViewById(R.id.endTimeDisplay).setVisibility(View.GONE);
                } else {

                    getView().findViewById(R.id.meetingDaysDisplay).setVisibility(View.VISIBLE);
                    getView().findViewById(R.id.sundayBtn).setVisibility(View.VISIBLE);
                    getView().findViewById(R.id.mondayBtn).setVisibility(View.VISIBLE);
                    getView().findViewById(R.id.tuesdayBtn).setVisibility(View.VISIBLE);
                    getView().findViewById(R.id.wednesdayBtn).setVisibility(View.VISIBLE);
                    getView().findViewById(R.id.thursdayBtn).setVisibility(View.VISIBLE);
                    getView().findViewById(R.id.fridayBtn).setVisibility(View.VISIBLE);
                    getView().findViewById(R.id.saturdayBtn).setVisibility(View.VISIBLE);
                    getView().findViewById(R.id.startTimeDisplay).setVisibility(View.VISIBLE);
                    getView().findViewById(R.id.startTime).setVisibility(View.VISIBLE);
                    getView().findViewById(R.id.endTime).setVisibility(View.VISIBLE);
                    getView().findViewById(R.id.endTimeDisplay).setVisibility(View.VISIBLE);
                }
            }
        });

        EditText startTime = (EditText)  getView().findViewById(R.id.startTime);
        startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        binding.startTime.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Deadline Time");
                mTimePicker.show();
            }
        });

        EditText endTime = (EditText)  getView().findViewById(R.id.endTime);
        endTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        binding.endTime.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Deadline Time");
                mTimePicker.show();
            }
        });

        this.binding.courseDoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable courseNameEditable = AddCourseView.this.binding.addedCourseNameInput.getText();
                String courseName = courseNameEditable.toString();

                Editable courseCodeEditable = AddCourseView.this.binding.addedCodeInput.getText();
                String courseCode = courseCodeEditable.toString();


                String semesterString = spinner.getSelectedItem().toString();
                Scanner scanner = new Scanner(semesterString);
                String semSeason = scanner.next();

                int semYear = scanner.nextInt();
                Semester courseSemester = new Semester(semSeason, semYear);


                ArrayList<Pair<LocalDateTime, LocalDateTime>> meetingTimes = new ArrayList<>();
                CheckBox[] daysOfTheWeek = new CheckBox[]{AddCourseView.this.binding.fridayBtn, AddCourseView.this.binding.mondayBtn,
                        AddCourseView.this.binding.tuesdayBtn, AddCourseView.this.binding.wednesdayBtn, AddCourseView.this.binding.thursdayBtn,
                        AddCourseView.this.binding.saturdayBtn, AddCourseView.this.binding.sundayBtn};
                Editable startTimeEditable = AddCourseView.this.binding.startTime.getText();
                String startTimeSt = startTimeEditable.toString();

                Editable endTimeEditable = AddCourseView.this.binding.endTime.getText();
                String endTimeSt = endTimeEditable.toString();


                if(binding.noMeetingTime.isChecked() == false){
                    for (CheckBox day : daysOfTheWeek){
                        DayOfWeek dayOfWeek = DayOfWeek.of(1);
                        if (String.valueOf(day.getText()).toLowerCase().compareTo("mon") == 0){
                            dayOfWeek = DayOfWeek.MONDAY;
                        }
                        else if (String.valueOf(day.getText()).toLowerCase().compareTo("tue") == 0){
                            dayOfWeek = DayOfWeek.TUESDAY;
                        }
                        else if (String.valueOf(day.getText()).toLowerCase().compareTo("wed") == 0){
                            dayOfWeek = DayOfWeek.WEDNESDAY;
                        }
                        else if (String.valueOf(day.getText()).toLowerCase().compareTo("thu") == 0){
                            dayOfWeek = DayOfWeek.THURSDAY;
                        }
                        else if (String.valueOf(day.getText()).toLowerCase().compareTo("fri") == 0){
                            dayOfWeek = DayOfWeek.FRIDAY;
                        }
                        else if (String.valueOf(day.getText()).toLowerCase().compareTo("sat") == 0){
                            dayOfWeek = DayOfWeek.SATURDAY;
                        }
                        else if (String.valueOf(day.getText()).toLowerCase().compareTo("sun") == 0){
                            dayOfWeek = DayOfWeek.SUNDAY;
                        }
                        LocalDate date = LocalDate.now();
                        date = date.with(TemporalAdjusters.next(dayOfWeek));
                        if (day.isChecked()){
                            LocalTime startTime = LocalTime.parse(startTimeSt);
                            LocalTime endTime = LocalTime.parse(endTimeSt);
                            LocalDateTime startDateTime = LocalDateTime.of(date, startTime);
                            LocalDateTime endDateTime = LocalDateTime.of(date, endTime);
                            Pair<LocalDateTime,LocalDateTime> startAndEnd = new Pair<>(startDateTime, endDateTime);
                            meetingTimes.add(startAndEnd);
                        }
                    }
                }
                Editable roomEditable = AddCourseView.this.binding.addedRoomInput.getText();
                String roomInfo = roomEditable.toString();

                Editable notesEditable = AddCourseView.this.binding.notesInput.getText();
                String notes = notesEditable.toString();

                Course newCourse = new Course(courseName, courseCode, courseSemester, notes, roomInfo, meetingTimes);
                System.out.println(newCourse);
            }
        });

    }

    @Override
    public View getRootView() {
        return null;
    }

    @Override
    public void updateCourseDisplay(Course course) {

    }


}