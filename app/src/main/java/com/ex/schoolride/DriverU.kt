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

class DriverU : AppCompatActivity() {

    private lateinit var tvRedirectSignUp: TextView
    lateinit var etDEmail: EditText
    private lateinit var etPass: EditText
    lateinit var btnLogin: Button

    // Creating firebaseAuth object
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driveruserlogin)

        // View Binding
        tvRedirectSignUp = findViewById(R.id.tvRedirectSignUp)
        btnLogin = findViewById(R.id.btnLogin)
        etDEmail = findViewById(R.id.etDEmailAddress)
        etPass = findViewById(R.id.etDPassword)

        // initialising Firebase auth object
        auth = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener {
            login()
        }

        tvRedirectSignUp.setOnClickListener {
            val intent = Intent(this, StudentLogin::class.java)
            startActivity(intent)
            // using finish() to end the activity
            finish()
        }
    }
    private fun login() {
        val email = etDEmail.text.toString()
        val pass = etPass.text.toString()
        // calling signInWithEmailAndPassword(email, pass)
        // function using Firebase auth object
        // On successful response Display a Toast
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully LoggedIn", Toast.LENGTH_SHORT).show()
                val intent = Intent(this,StudentLogin::class.java)
                startActivity(intent)
                // using finish() to end the activity
                finish()
            } else
                Toast.makeText(this, "Log In failed ", Toast.LENGTH_SHORT).show()
        }
    }


}