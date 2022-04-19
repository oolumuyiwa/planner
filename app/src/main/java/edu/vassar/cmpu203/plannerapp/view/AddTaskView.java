package edu.vassar.cmpu203.plannerapp.view;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.snackbar.Snackbar;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import edu.vassar.cmpu203.plannerapp.R;
import edu.vassar.cmpu203.plannerapp.controller.MainActivity;
import edu.vassar.cmpu203.plannerapp.databinding.FragmentAddTaskViewBinding;
import edu.vassar.cmpu203.plannerapp.model.Course;
import edu.vassar.cmpu203.plannerapp.model.Task;


public class AddTaskView extends Fragment
        implements IAddTaskView, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

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

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        Spinner courseSpinner = (Spinner) getView().findViewById(R.id.courseSpinner);
        MainActivity mainActivity = (MainActivity) getActivity();
        ArrayAdapter<Course> courseArrayAdapter = new ArrayAdapter<Course>(getContext(), android.R.layout.simple_spinner_item, mainActivity.getCourses());
        courseArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        courseSpinner.setAdapter(courseArrayAdapter);

        courseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) view).setTextColor(binding.createTaskDisplay.getTextColors());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner spinner = (Spinner) getView().findViewById(R.id.taskTypesSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.task_type_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                //Change the selected item's text color
                ((TextView) view).setTextColor(binding.createTaskDisplay.getTextColors());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });

        final Calendar newCalendar = Calendar.getInstance();
        DateFormat dateFormatter = DateFormat.getDateInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                String date = monthOfYear + "/" + dayOfMonth + "/" + year;
                binding.taskDateInput.setText(date);
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        Switch noDeadline = (Switch)  getView().findViewById(R.id.noDeadline);


        noDeadline.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    getView().findViewById(R.id.taskDateInput).setVisibility(View.GONE);

                } else {
                    getView().findViewById(R.id.taskDateInput).setVisibility(View.VISIBLE);
                }
            }
        });

        EditText taskDateInput = (EditText) getView().findViewById(R.id.taskDateInput);
        taskDateInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });

        Switch addDeadlineTime = (Switch) getView().findViewById(R.id.addDeadlineTime);
        addDeadlineTime.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    getView().findViewById(R.id.taskTimeInput).setVisibility(View.VISIBLE);

                } else {
                    getView().findViewById(R.id.taskTimeInput).setVisibility(View.GONE);
                }
            }
        });

        EditText taskTimeInput = (EditText)  getView().findViewById(R.id.taskTimeInput);
        taskTimeInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String selectedHourSt = "" + selectedHour;
                        if (selectedHour < 10){
                            selectedHourSt = "0" + selectedHourSt;
                        }
                        String selectedMinuteSt = "" + selectedMinute;
                        if (selectedMinute < 10){
                            selectedMinuteSt = "0" + selectedMinuteSt;
                        }
                        binding.taskTimeInput.setText( selectedHourSt + ":" + selectedMinuteSt);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Deadline Time");
                mTimePicker.show();
            }
        });

        this.binding.taskDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validInfo() == false) {
                    Snackbar snackbar = Snackbar.make(getView(), "Invalid Info. Please give complete information and try again.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }else  if (prePresentDeadline()){
                    Snackbar snackbar = Snackbar.make(getView(), "Come on, the deadline can't be in the past.", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                else {
                //get task name
                Editable taskNameEditable = AddTaskView.this.binding.addedNameInput.getText();
                String taskName = taskNameEditable.toString();

                LocalDate deadlineDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
                    if (AddTaskView.this.binding.noDeadline.isChecked()) {
                        deadlineDate = LocalDate.MAX;
                    }
                    else{
                        deadlineDate = LocalDate.parse(AddTaskView.this.binding.taskDateInput.getText().toString(), formatter);
                    }

                    LocalTime deadlineTime = LocalTime.now();
                    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("H:mm");
                    if(AddTaskView.this.binding.addDeadlineTime.isChecked()){
                        deadlineTime = LocalTime.parse(AddTaskView.this.binding.taskTimeInput.getText().toString(), formatter2);
                    }
                    LocalDateTime deadline = LocalDateTime.of(deadlineDate, deadlineTime);
                    Course associatedCourse = new Course();
                    if (!(courseSpinner.getSelectedItem().getClass() == Course.class)){
                        associatedCourse = null;
                    }
                    else{
                        associatedCourse = (Course) courseSpinner.getSelectedItem();
                    }
                    String type = spinner.getSelectedItem().toString();
                    String notes = AddTaskView.this.binding.additionalNotesInput.getText().toString();
                    Task newTask = new Task(taskName, type, associatedCourse, deadline, notes);
                    if(associatedCourse != null) {
                        associatedCourse.tasks.add(newTask);
                    }
                    AddTaskView.this.listener.onAddedTask(newTask);
                    AddTaskView.this.listener.onAddTaskDone(newTask);
                }
            }
        });

    }
    public boolean prePresentDeadline(){
        LocalDate deadlineDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        deadlineDate = LocalDate.parse(AddTaskView.this.binding.taskDateInput.getText().toString(), formatter);
        LocalTime deadlineTime = LocalTime.now();
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("H:mm");
        deadlineTime = LocalTime.parse(AddTaskView.this.binding.taskTimeInput.getText().toString(), formatter2);
        LocalDateTime deadline = LocalDateTime.of(deadlineDate, deadlineTime);
        boolean res = deadline.isBefore(LocalDateTime.now());
        return res;
    }

    public boolean validInfo(){
        boolean filledName = AddTaskView.this.binding.addedNameInput.getText().toString().length() > 1;
        boolean flippedSwitch = AddTaskView.this.binding.noDeadline.isChecked();
        boolean filledDate = (AddTaskView.this.binding.taskDateInput.getText().toString().length() > 1);
        if (flippedSwitch){
            filledDate = true;
        }
        boolean validTimeInput = (AddTaskView.this.binding.taskTimeInput.getText().toString().length() > 1);
        boolean flippedAddTimeSwitch = AddTaskView.this.binding.noDeadline.isChecked();
        if(flippedAddTimeSwitch == false){
            validTimeInput = true;
        }
        boolean validInfo = (filledName && validTimeInput && filledDate);
        return validInfo;
    }
    @Override
    public View getRootView() {
        return null;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {}

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {}
}