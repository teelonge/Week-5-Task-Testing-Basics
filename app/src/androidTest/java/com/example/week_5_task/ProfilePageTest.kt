package com.example.week_5_task


import androidx.test.espresso.Espresso.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProfilePageTest {
    @Rule @JvmField
    val profilePageActivity = ActivityScenarioRule(ProfilePage::class.java)

    @Test
    fun visibilityChecker_beforeRegistrationExistsAndVisible_returnsTrue() {

        // checks the views in the second activity if they exist
        onView(withId(R.id.txtProfileName)).check(matches(isDisplayed()))
        onView(withId(R.id.txtProfilePage)).check(matches(isDisplayed()))
        onView(withId(R.id.txtEmail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtPhoneNumber)).check(matches(isDisplayed()))
        onView(withId(R.id.txtMf)).check(matches(isDisplayed()))
        onView(withId(R.id.designContainer)).check(matches(isDisplayed()))
        onView(withId(R.id.bottomImageContainer)).check(matches(isDisplayed()))
    }
}