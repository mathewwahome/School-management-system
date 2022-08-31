package com.example.school

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class IntroActivity : AppCompatActivity() {
    private lateinit var start:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        supportActionBar?.hide()
        start = findViewById(R.id.start)

        start.setOnClickListener {
            val now = Intent(applicationContext, MainActivity::class.java)
            startActivity(now)
        }
    }
}