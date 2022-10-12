package com.ex.schoolride

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class DLogin : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dslogin)

        var btnDLogin = findViewById<Button>(R.id.btnDSigned)

        btnDLogin.setOnClickListener {
            val Intent = Intent(this, DriverLogin::class.java)
            startActivity(Intent)
            // using finish() to end the activity
            finish()
        }
    }

    }
