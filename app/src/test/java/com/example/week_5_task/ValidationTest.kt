package com.example.week_5_task

import com.example.week_5_task.Validation.validatePhoneNumber
import org.hamcrest.CoreMatchers.`is`
import org.junit.Test

import org.junit.Assert.*

class ValidationTest {

    @Test
    fun validatePhoneNumber_startWith234_returnsTrue() {
        // Given a phoneNumber to validate
        val phoneNumber = "2348090539526"
        // When
        val result = validatePhoneNumber(phoneNumber)
        // Then
        assertThat(result,`is`(true))
    }

    @Test
    fun validatePhoneNumber_startWith080_returnsTrue() {
        // Given a phoneNumber to validate
        val phoneNumber = "08090539526"
        // When
        val result = validatePhoneNumber(phoneNumber)
        // Then
        assertThat(result,`is`(true))
    }

    @Test
    fun validatePhoneNumber_startWith070_returnsTrue() {
        // Given a phoneNumber to validate
        val phoneNumber = "07090539526"
        // When
        val result = validatePhoneNumber(phoneNumber)
        // Then
        assertThat(result,`is`(true))
    }

    @Test
    fun validatePhoneNumber_startWith090_returnsTrue() {
        // Given a phoneNumber to validate
        val phoneNumber = "09090539526"
        // When
        val result = validatePhoneNumber(phoneNumber)
        // Then
        assertThat(result,`is`(true))
    }

    @Test
    fun validatePhoneNumber_startWith081_returnsTrue() {
        // Given a phoneNumber to validate
        val phoneNumber = "08190539526"
        // When
        val result = validatePhoneNumber(phoneNumber)
        // Then
        assertThat(result,`is`(true))
    }

    @Test
    fun validatePhoneNumber_startWith091_returnsTrue() {
        // Given a phoneNumber to validate
        val phoneNumber = "09190539526"
        // When
        val result = validatePhoneNumber(phoneNumber)
        // Then
        assertThat(result,`is`(true))
    }

    @Test
    fun validatePhoneNumber_lengthLessThan11OrGreaterThan13_returnsFalse(){
        // Given a phoneNumber to validate
        val phoneNumber = "238439526"
        val phoneNumber2 = "080903456786"
        // When
        val result = validatePhoneNumber(phoneNumber)
        val result2 = validatePhoneNumber(phoneNumber2)
        // Then
        assertThat(result,`is`(false))
        assertThat(result2,`is`(false))
    }

    @Test
    fun validatePhoneNumber_anyNumberAsidesNigeria_returnsFalse(){
        // Given a phoneNumber to validate
        val phoneNumber1 = "53843952690"
        val phoneNumber2 = "07125584885"
        val phoneNumber3 = "2358756453215"
        // When
        val result = validatePhoneNumber(phoneNumber1)
        val result2 = validatePhoneNumber(phoneNumber2)
        val result3 = validatePhoneNumber(phoneNumber3)
        // Then
        assertThat(result,`is`(false))
        assertThat(result2,`is`(false))
        assertThat(result3,`is`(false))
    }

    @Test
    fun validatePhoneNumber_containsCharactersAsidesDigit_returnsFalse(){
       // Given a phoneNumber to validate
        val phoneNumber1 = "23480*9293490"
        // When
        val result = validatePhoneNumber(phoneNumber1)
        // Then
        assertThat(result,`is`(false))
    }
}