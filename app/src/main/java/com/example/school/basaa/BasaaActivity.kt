package com.example.school.basaa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.school.R

class BasaaActivity : AppCompatActivity() {
    private lateinit var signin:TextView
    private lateinit var signup:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basaa)
        supportActionBar?.hide()

        signin = findViewById(R.id.basaa_signin)
        signup = findViewById(R.id.basaa_signup)

        signin.setOnClickListener {
            val intent = Intent(applicationContext, BasaaLogin::class.java)
            startActivity(intent)
        }
        signup.setOnClickListener {
            val intent = Intent(applicationContext, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}