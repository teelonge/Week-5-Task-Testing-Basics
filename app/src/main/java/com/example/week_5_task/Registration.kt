package com.example.week_5_task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class Registration : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var edtName : TextInputEditText
    private lateinit var edtPhone : TextInputEditText
    private lateinit var edtMail : TextInputEditText
    private lateinit var spinner : Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        edtName = findViewById(R.id.edtName)
        edtPhone = findViewById(R.id.edt_phoneNumber)
        edtMail = findViewById(R.id.edtE_mail)
        spinner = findViewById(R.id.spinner)
        val txtError = findViewById<TextView>(R.id.txtError)

        // Creates a spinner for gender selection
        spinner.onItemSelectedListener = this
        ArrayAdapter.createFromResource(
            this,
            R.array.sex,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        // TextWatcher to remove error message when user starts typing
        edtPhone.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                txtError.visibility = View.GONE
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })

        /*
         Validates the phoneNumber and creates a new profile if user inputs correct phone number
         */
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        btnRegister.setOnClickListener {
            txtError.visibility = View.GONE
            val intent = Intent(this, ProfilePage::class.java)
           intent.putExtra(NAME,edtName.text.toString())
            intent.putExtra(PHONE_NUMBER,edtPhone.text.toString())
            intent.putExtra(E_MAIL,edtMail.text.toString())
            intent.putExtra(SEX,spinner.selectedItem.toString())
            if (Validation.validatePhoneNumber(edtPhone.text.toString())){
                txtError.visibility = View.GONE
                startActivity(intent)
            }else{
                txtError.visibility = View.VISIBLE
            }

        }
    }

    // Clears editText contents upon navigation to the second activity
    override fun onStop() {
        super.onStop()
        edtName.text?.clear()
        edtMail.text?.clear()
        edtPhone.text?.clear()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
}

