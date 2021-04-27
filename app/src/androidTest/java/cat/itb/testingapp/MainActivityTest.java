package cat.itb.testingapp;

import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;

import androidx.test.espresso.intent.*;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.intent.Intents.*;
import static androidx.test.espresso.intent.matcher.IntentMatchers.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static cat.itb.testingapp.MainActivity.PASS_TO_BE_TYPED;
import static cat.itb.testingapp.MainActivity.USER_TO_BE_TYPED;

public class MainActivityTest {

    @Rule
    public ActivityScenarioRule rule = new ActivityScenarioRule<>(MainActivity.class);


    @Test
    public void checkAreDisplayed(){
        ActivityScenario scenario = rule.getScenario();
        onView(withId(R.id.textView)).check(matches(isDisplayed()));
        onView(withId(R.id.button)).check(matches(isDisplayed()));
    }

    @Test
    public void checkText(){
        ActivityScenario scenario = rule.getScenario();
        onView(withId(R.id.textView)).check(matches(withText("Main Activity Title")));
        onView(withId(R.id.button)).check(matches(withText("NEXT")));
    }

    @Test
    public void checkClickableAndTextButton(){
        ActivityScenario scenario = rule.getScenario();
        onView(withId(R.id.button)).check(matches(isClickable())).perform(click()).check(matches(withText("BACK")));

    }

    @Test
    public void login_form_behaviour(){
        ActivityScenario scenario = rule.getScenario();
        onView(withId(R.id.username)).perform(typeText(USER_TO_BE_TYPED)).perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText(PASS_TO_BE_TYPED)).perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.button)).check(matches(isClickable())).perform(click()).check(matches(withText("LOGGED")));


    }

    @Test
    public void changeActivity(){
        ActivityScenario scenario = rule.getScenario();


        Intents.init();
        onView(withId(R.id.button)).check(matches(isClickable())).perform(click());
        intended(hasComponent(SecondActivity.class.getName()));
        Intents.release();

    }
    @Test
    public void changeActivityAndReturn(){
        ActivityScenario scenario = rule.getScenario();


        Intents.init();
        onView(withId(R.id.button)).check(matches(isClickable())).perform(click());

        intended(hasComponent(SecondActivity.class.getName()));
        Intents.release();
        Intents.init();
        onView(withId(R.id.buttonSecondActivity)).check(matches(isClickable())).perform(click());

        intended(hasComponent(MainActivity.class.getName()));
        Intents.release();
    }

    @Test
    public void largeTest(){
        ActivityScenario scenario = rule.getScenario();

        checkText();
        onView(withId(R.id.username)).perform(typeText(USER_TO_BE_TYPED)).perform(ViewActions.closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText(PASS_TO_BE_TYPED)).perform(ViewActions.closeSoftKeyboard());
        Intents.init();
        onView(withId(R.id.button)).check(matches(isClickable())).perform(click());
        intended(hasComponent(SecondActivity.class.getName()));
        Intents.release();
        Intents.init();
        onView(withId(R.id.textView2)).check(matches(withText("Welcome back "+ USER_TO_BE_TYPED)));
        onView(withId(R.id.buttonSecondActivity)).check(matches(isClickable())).perform(click());
        intended(hasComponent(MainActivity.class.getName()));
        Intents.release();
        onView(withId(R.id.username)).check(matches(withText("")));
        onView(withId(R.id.password)).check(matches(withText("")));




    }






}