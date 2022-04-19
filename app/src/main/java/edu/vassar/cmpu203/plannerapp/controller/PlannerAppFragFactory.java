package edu.vassar.cmpu203.plannerapp.controller;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

import edu.vassar.cmpu203.plannerapp.view.AddCourseView;
import edu.vassar.cmpu203.plannerapp.view.AddTaskView;
import edu.vassar.cmpu203.plannerapp.view.CoursesView;
import edu.vassar.cmpu203.plannerapp.view.TasksView;

//currently not in use, for future iterations
public class PlannerAppFragFactory extends FragmentFactory {

    private MainActivity controller;

    public PlannerAppFragFactory(MainActivity controller){this.controller = controller;}

    public Fragment instantiate(ClassLoader classLoader, String className){
        Class<? extends Fragment> fragClass = loadFragmentClass(classLoader, className);

        if (fragClass == AddCourseView.class)
            return new AddCourseView(controller);
        else if (fragClass == AddTaskView.class)
            return new AddTaskView(controller);
        else if (fragClass == TasksView.class)
            return new TasksView(controller);
        else if (fragClass == CoursesView.class)
            return new CoursesView(controller);
        else
            return super.instantiate(classLoader, className);
    }
}
