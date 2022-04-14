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

import static org.junit.Assert.*;

import edu.vassar.cmpu203.plannerapp.controller.MainActivity;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class AddItemsInstTest {

    @org.junit.Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void addItemsTest() {
        // check that line items is empty at the start
        Matcher<View> lineItemsMatcher = ViewMatchers.withId(R.id.addedNameInput).;
        ViewInteraction lineItemsVi = Espresso.onView(lineItemsMatcher);
        lineItemsVi.check(ViewAssertions.matches(ViewMatchers.withText("")));

        // add 10 units of guacamole
        ViewInteraction nameInputVi = Espresso.onView(ViewMatchers.withId(R.id.nameInputText));
        nameInputVi.perform(ViewActions.typeText("guacamole"));

        ViewInteraction qtyInputVi = Espresso.onView(ViewMatchers.withId(R.id.qtyInputText));
        qtyInputVi.perform(ViewActions.typeText("10"));

        ViewInteraction addButtonVi = Espresso.onView(ViewMatchers.withId(R.id.addButton));
        addButtonVi.perform(ViewActions.click());

        // check that guacamole shows up in line items label
        lineItemsVi.check(ViewAssertions.matches(ViewMatchers.withSubstring("guacamole")));
    }
}