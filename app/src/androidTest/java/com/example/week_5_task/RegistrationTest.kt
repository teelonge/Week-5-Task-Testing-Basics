package com.example.week_5_task


import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class RegistrationTest {
    private val name = "Naomi Osaka"
    private val phoneNumber = "2348032565670"
    private val email = "naomi_osaka@gmail.com"
    private val sex = "Female"

    // Starts the activity to run the test in
    @Rule @JvmField
    val registrationActivity = ActivityScenarioRule(Registration::class.java)

    @Test
    fun registration_generatesNewUserProfileUponValidation_returnsTrue(){

        // When the following actions are performed
        onView(withId(R.id.edtName)).perform(typeText(name))
        onView(withId(R.id.edt_phoneNumber)).perform(typeText(phoneNumber))
        onView(withId(R.id.edtE_mail)).perform(typeText(email))
        onView(withId(R.id.spinner)).perform(click())
        onData(allOf(`is`(instanceOf(String::class.java)),`is`(sex))).perform(click())
        onView(withId(R.id.spinner)).check(matches(withSpinnerText(sex)))
        onView(withId(R.id.btnRegister)).perform(click())

        // Then Checks for the generated value if it matches
        onView(withId(R.id.txtName)).check(matches(withText(name)))
        onView(withId(R.id.txtPhone)).check(matches(withText(phoneNumber)))
        onView(withId(R.id.txtSex)).check(matches(withText(sex)))
        onView(withId(R.id.txtMail)).check(matches(withText(email)))
    }

    @Test
    fun visibilityChecker_existsAndVisible_returnsTrue(){

        // Checks that each of the visible on the UI
        onView(withId(R.id.edtName)).check(matches(isDisplayed()))
        onView(withId(R.id.edt_phoneNumber)).check(matches(isDisplayed()))
        onView(withId(R.id.edtE_mail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtWelcome)).check(matches(isDisplayed()))
        onView(withId(R.id.txtSexHolder)).check(matches(isDisplayed()))

        // Checks that the error message is not visible yet
        onView(withId(R.id.txtError)).check(matches(not(isDisplayed())))

        // Given the following details

        // When the following actions are performed
        onView(withId(R.id.edtName)).perform(typeText(name))
        onView(withId(R.id.edt_phoneNumber)).perform(typeText(phoneNumber))
        onView(withId(R.id.edtE_mail)).perform(typeText(email))
        onView(withId(R.id.spinner)).perform(click())
        onData(allOf(`is`(instanceOf(String::class.java)),`is`(sex))).perform(click())
        onView(withId(R.id.btnRegister)).perform(click())

        // Checks that the respective views are visible and displayed
        onView(withId(R.id.txtProfileName)).check(matches(isDisplayed()))
        onView(withId(R.id.txtProfilePage)).check(matches(isDisplayed()))
        onView(withId(R.id.txtName)).check(matches(isDisplayed()))
        onView(withId(R.id.txtEmail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtMail)).check(matches(isDisplayed()))
        onView(withId(R.id.txtSex)).check(matches(isDisplayed()))
        onView(withId(R.id.txtPhone)).check(matches(isDisplayed()))
        onView(withId(R.id.txtPhoneNumber)).check(matches(isDisplayed()))
        onView(withId(R.id.txtMf)).check(matches(isDisplayed()))
        onView(withId(R.id.designContainer)).check(matches(isDisplayed()))
        onView(withId(R.id.bottomImageContainer)).check(matches(isDisplayed()))

    }

    @Test
    fun errorMessage_visibleWhenWrongInput_returnsTrue(){
        // Given a wrong phoneNumber
        val phoneNumber = "234$9*0538726"

        // When the following actions are performed
        onView(withId(R.id.edt_phoneNumber)).perform(typeText(phoneNumber))
        onView(withId(R.id.btnRegister)).perform(click())

        // Then the error message gets displayed
        onView(withId(R.id.txtError)).check(matches(isDisplayed()))
    }


}