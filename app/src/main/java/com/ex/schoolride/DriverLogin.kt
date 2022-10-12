package com.ex.schoolride

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class DriverLogin : AppCompatActivity() {
    lateinit var etDName: EditText
    lateinit var etvehicle: EditText
    lateinit var etNic: EditText
    lateinit var etaddress: EditText
    lateinit var driverN: EditText
    lateinit var etDEmail: EditText
    private lateinit var etPass: EditText
    private lateinit var btnSignUp: Button
    lateinit var tvRedirectLogin: TextView

    // create Firebase authentication object
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_login)


        // View Bindings
        etDEmail = findViewById(R.id.etDEmailAddress)
        etPass = findViewById(R.id.etDPassword)
         etDName= findViewById(R.id.etDname)
         etvehicle= findViewById(R.id.etDvehicle)
         etNic= findViewById(R.id.etDNic)
         etaddress= findViewById(R.id.etDAddress)
         driverN= findViewById(R.id.etDdriverNo)
        btnSignUp = findViewById(R.id.btnSSigned)
        tvRedirectLogin = findViewById(R.id.tvRedirectLogin)

        // Initialising auth object
        auth = Firebase.auth

        btnSignUp.setOnClickListener {
            signUpUser()
        }

        // switching from signUp Activity to Login Activity
        tvRedirectLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun signUpUser() {
        val email = etDEmail.text.toString()
        val pass = etPass.text.toString()

        // check pass
        if (email.isBlank() || pass.isBlank()) {
            Toast.makeText(this, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
            return
        }

        // If all credential are correct
        // We call createUserWithEmailAndPassword
        // using auth object and pass the
        // email and pass in it.
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully Signed Up", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Signed Up Failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}



