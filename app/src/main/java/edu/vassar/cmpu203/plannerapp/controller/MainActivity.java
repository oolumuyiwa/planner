package edu.vassar.cmpu203.plannerapp.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import android.widget.TextView;
import android.widget.Toast;
//import android.util.Pair;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import edu.vassar.cmpu203.plannerapp.model.Library;
import edu.vassar.cmpu203.plannerapp.model.Course;
import edu.vassar.cmpu203.plannerapp.model.Task;
import edu.vassar.cmpu203.plannerapp.view.*;
import org.apache.commons.io.FileUtils;

public class MainActivity extends AppCompatActivity
        implements ITasksView.Listener, IAddTaskView.Listener, IAddCourseView.Listener, ICoursesView.Listener, Serializable {

    // keeps track of the main view
    private IMainView mainView;

    public Library library = new Library();


    public void serializeLibrary(Library library) {
        File path = getApplicationContext().getFilesDir();
        File f1  = new File(path, "library");
        try {
            FileOutputStream fos
                    = new FileOutputStream(f1);

            // an ObjectOutputStream object is
            // created on the FileOutputStream
            // object
            ObjectOutputStream oos
                    = new ObjectOutputStream(fos);

            // calling the writeObject()
            // method of the
            // ObjectOutputStream on the
            // OutputStream file "library"
            oos.writeObject(library);

            // close the ObjectOutputStream
            oos.close();

            // close the OutputStream file
            fos.close();

            Toast.makeText(getApplicationContext(), "library serialized", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Library deserializeLibrary(){
       Library res = new Library();
        File path = getApplicationContext().getFilesDir();
        File f1  = new File(path, "library");
        try
        {
            FileInputStream fis = new FileInputStream(f1);
            ObjectInputStream ois = new ObjectInputStream(fis);

            res = (Library) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();

        }
        catch (ClassNotFoundException c)
        {
            c.printStackTrace();
        }
        return res;
    }

    


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        serializeLibrary(library);
    }

    @Override
    //creates the first view that the user sees on app open after refresh
    protected void onCreate(Bundle savedInstanceState) {

        library = deserializeLibrary();

        super.onCreate(savedInstanceState);
        this.mainView = new MainView(this);
        setContentView(this.mainView.getRootView());
        this.mainView.displayFragment(new TasksView(this), true);
    }

    @Override
    //returns to TaskView
    public void onAddTaskDone(Task task) {
        this.mainView.displayFragment(new TasksView(this), true);

    }

    @Override
    //adds created task to array of allTasks
    public void onAddedTask(Task task) {
        library.getTasks().add(task);

    }

    @Override
    //activates on add button click, opens up AddTaskView screen
    public void onAddTask() {
        this.mainView.displayFragment(new AddTaskView(this), true);
    }

    @Override
    public void onClickTaskPane() {
        this.mainView.displayFragment(new CoursesView(this), true);
    }

    @Override
    public void onAddedCourse(Course course) {
        library.getCourses().add(course);

    }

    @Override
    public void onAddCourseDone(Course course) {
        //coursesView.updateCourseDisplay(MainActivity.allCourses);


        Bundle argsBundle = CoursesView.makeArgsBundle(library.getCourses().toString());
        Fragment coursesView = new CoursesView(this);
        coursesView.setArguments(argsBundle);
        this.mainView.displayFragment(coursesView, true);

    }

    @Override
    public void onAddCourse() {
        this.mainView.displayFragment(new AddCourseView(this), true);
    }

    @Override
    public void onClickCoursePane() {
        this.mainView.displayFragment(new TasksView(this), true);
    }
}