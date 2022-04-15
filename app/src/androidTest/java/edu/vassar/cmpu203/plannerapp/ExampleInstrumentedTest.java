package edu.vassar.cmpu203.plannerapp;

import android.content.Context;
import android.view.View;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import edu.vassar.cmpu203.plannerapp.controller.MainActivity;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @org.junit.Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void addCourseTest() {

        //navigate to create course view
        ViewInteraction paneVi = Espresso.onView(ViewMatchers.withId(R.id.paneName));
        paneVi.perform(ViewActions.click());

        ViewInteraction addCourseVi = Espresso.onView(ViewMatchers.withId(R.id.addCourse));
        addCourseVi.perform(ViewActions.click());

        // add course name
        ViewInteraction addedCourseNameVi = Espresso.onView(ViewMatchers.withId(R.id.addedCourseNameInput));
        addedCourseNameVi.perform(ViewActions.typeText("intro to computer science"));

        // add course code
        ViewInteraction addedCodeVi = Espresso.onView(ViewMatchers.withId(R.id.addedCodeInput));
        addedCodeVi.perform(ViewActions.typeText("CMPU 101"));

        // click on "fall 2022" in spinner
        ViewInteraction courseSemesterVi = Espresso.onView(ViewMatchers.withId(R.id.courseSemesterSpinner));
        courseSemesterVi.perform(ViewActions.click());
        Espresso.onData(instanceOf(String.class)).atPosition(1).perform(ViewActions.click());
        //Espresso.onData(allOf(is(instanceOf(String.class)), is(selectionText))).perform(click());

        //click on "meets on monday and wednesday"
        ViewInteraction mondayVi = Espresso.onView(ViewMatchers.withId(R.id.mondayBtn));
        mondayVi.perform(ViewActions.click());
        ViewInteraction wednesdayVi = Espresso.onView(ViewMatchers.withId(R.id.wednesdayBtn));
        wednesdayVi.perform(ViewActions.click());


        //enter start and end time
        ViewInteraction startVi = Espresso.onView(ViewMatchers.withId(R.id.startTime));
        startVi.perform(ViewActions.typeText("1200"));
        ViewInteraction endVi = Espresso.onView(ViewMatchers.withId(R.id.endTime));
        endVi.perform(ViewActions.typeText("0115"));

        //click done
        ViewInteraction courseDoneVi = Espresso.onView(ViewMatchers.withId(R.id.courseDoneBtn));
        courseDoneVi.perform(ViewActions.click());

        // TODO check that course entry shows up in course view with proper parameters

        // notes: tests fail due to finicky implementation of start/end time (requires double press?)
        // also because invalid entry checking is wrong

    }
}