package com.example.school.basaa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.school.R

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.hide()

    }
}