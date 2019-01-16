package com.example.calculator;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    public static ViewAction setTextInTextView(final String value){    // used to set text to edittext to test the clear button and equation to test the equation button
        return new ViewAction() {
            @SuppressWarnings("unchecked")
            @Override
            public Matcher<View> getConstraints() {
                return allOf(isDisplayed(), isAssignableFrom(TextView.class));
//                                            ^^^^^^^^^^^^^^^^^^^
// To check that the found view is TextView or it's subclass like EditText
// so it will work for TextView and it's descendants
            }

            @Override
            public void perform(UiController uiController, View view) {
                ((TextView) view).setText(value);
            }

            @Override
            public String getDescription() {
                return "replace text";
            }
        };
    }

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);


    @Before
    public void setUp() throws Exception {
        Intents.init();
    }

    @After
    public void tearDown() throws Exception {
        Intents.release();
    }

    @Test
    public void buttonHistory() {
        onView(ViewMatchers.withId(R.id.buttonHistory))
                .perform(click());

        intended(hasComponent(DisplayHistoryActivity.class.getName()));

    }

    @Test
    public void buttonEquals() {
        onView(withId(R.id.textView))
                .perform(setTextInTextView("2+2-3*4"));

        onView(withId(R.id.buttonEquals)).perform(click());
        String mTestedString = "-8.0";

        onView(withId(R.id.textView))
                .check(matches(withText(mTestedString)));
    }

    @Test
    public void buttonOne() {
        onView(withId(R.id.buttonOne)).perform(click());
        String mTestedString = "1";

        onView(withId(R.id.textView))
                .check(matches(withText(mTestedString)));
    }

    @Test
    public void buttonTwo() {
        onView(withId(R.id.buttonTwo)).perform(click());
        String mTestedString = "2";

        onView(withId(R.id.textView))
                .check(matches(withText(mTestedString)));
    }

    @Test
    public void buttonThree() {
        onView(withId(R.id.buttonThree)).perform(click());
        String mTestedString = "3";

        onView(withId(R.id.textView))
                .check(matches(withText(mTestedString)));
    }

    @Test
    public void buttonFour() {
        onView(withId(R.id.buttonFour)).perform(click());
        String mTestedString = "4";

        onView(withId(R.id.textView))
                .check(matches(withText(mTestedString)));
    }

    @Test
    public void buttonFive() {
        onView(withId(R.id.buttonFive)).perform(click());
        String mTestedString = "5";

        onView(withId(R.id.textView))
                .check(matches(withText(mTestedString)));
    }

    @Test
    public void buttonSix() {
        onView(withId(R.id.buttonSix)).perform(click());
        String mTestedString = "6";

        onView(withId(R.id.textView))
                .check(matches(withText(mTestedString)));
    }

    @Test
    public void buttonSeven() {
        onView(withId(R.id.buttonSeven)).perform(click());
        String mTestedString = "7";

        onView(withId(R.id.textView))
                .check(matches(withText(mTestedString)));
    }

    @Test
    public void buttonEight() {
        onView(withId(R.id.buttonEight)).perform(click());
        String mTestedString = "8";

        onView(withId(R.id.textView))
                .check(matches(withText(mTestedString)));
    }

    @Test
    public void buttonNine() {
        onView(withId(R.id.buttonNine)).perform(click());
        String mTestedString = "9";

        onView(withId(R.id.textView))
                .check(matches(withText(mTestedString)));
    }

    @Test
    public void buttonZero() {
        onView(withId(R.id.buttonZero)).perform(click());
        String mTestedString = "0";

        onView(withId(R.id.textView))
                .check(matches(withText(mTestedString)));
    }

    @Test
    public void buttonDot() {
        onView(withId(R.id.buttonDot)).perform(click());
        String mTestedString = ".";

        onView(withId(R.id.textView))
                .check(matches(withText(mTestedString)));
    }


    @Test
    public void buttonClear() {
        onView(withId(R.id.textView))
                .perform(setTextInTextView("4+4*4"));

        onView(withId(R.id.buttonClear)).perform(click());
        String mTestedString = "";

        onView(withId(R.id.textView))
                .check(matches(withText(mTestedString)));
    }

    @Test
    public void buttonPlus() {
        onView(withId(R.id.buttonPlus)).perform(click());
        String mTestedString = "+";

        onView(withId(R.id.textView))
                .check(matches(withText(mTestedString)));
    }

    @Test
    public void buttonMinus() {
        onView(withId(R.id.buttonMinus)).perform(click());
        String mTestedString = "-";

        onView(withId(R.id.textView))
                .check(matches(withText(mTestedString)));
    }

    @Test
    public void buttonMultiply() {
        onView(withId(R.id.buttonMultiply)).perform(click());
        String mTestedString = "*";

        onView(withId(R.id.textView))
                .check(matches(withText(mTestedString)));
    }

    @Test
    public void buttonDivide() {
        onView(withId(R.id.buttonDivide)).perform(click());
        String mTestedString = "/";

        onView(withId(R.id.textView))
                .check(matches(withText(mTestedString)));
    }
}