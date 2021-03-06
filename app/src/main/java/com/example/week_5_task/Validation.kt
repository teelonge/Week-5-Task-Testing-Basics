package com.example.week_5_task

/**
 * An object class that is called to validate entries from the user
 */
object Validation {

    /**
     * Validates users phoneNumber and generates a profile if correct
     * @param phoneNumber : phone number entry to be validated
     * @return true if it matches the specified input
     */
    fun validatePhoneNumber(phoneNumber : String) : Boolean{
        if (phoneNumber.length < 11) return false
        return when
        {
            (((((phoneNumber.substring(0..4) == "23480") || (phoneNumber.substring(0..4) == "23481")
                    || (phoneNumber.substring(0..4) == "23491") || (phoneNumber.substring(0..4) == "23490")
                    || (phoneNumber.substring(0..4) == "23470") )&& (phoneNumber.length==13)) ||
                    (((phoneNumber.substring(0..2)=="080") || (phoneNumber.substring(0..2)=="091")
                            || (phoneNumber.substring(0..2)=="081") || (phoneNumber.substring(0..2)=="070")
                            || (phoneNumber.substring(0..2)=="090")) && (phoneNumber.length == 11))))
                    && (phoneNumber.all { it.isDigit() }) -> true
            else -> false
        }
    }
}