package com.example.week_5_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

/**
 * Generates a new profile for the user if the phoneNumber entered is correct and matches
 * the Nigeria telephone numbers
 */
class ProfilePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)

        val txtName = findViewById<TextView>(R.id.txtName)
        val txtPhone = findViewById<TextView>(R.id.txtPhone)
        val txtMail = findViewById<TextView>(R.id.txtMail)
        val txtSex = findViewById<TextView>(R.id.txtSex)

        // Sets respective textField based on user's input from the registration portal
        txtName.text = intent.getStringExtra(NAME)
        txtPhone.text = intent.getStringExtra(PHONE_NUMBER)
        txtMail.text = intent.getStringExtra(E_MAIL)
        txtSex.text = intent.getStringExtra(SEX)

    }

}