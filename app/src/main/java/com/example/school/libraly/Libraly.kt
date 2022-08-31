package com.example.school.libraly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.school.R

class Libraly : AppCompatActivity() {
    private lateinit var viewbooks:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_libraly)
        viewbooks = findViewById(R.id.viewbooks)

        viewbooks.setOnClickListener {
            val intent = Intent(applicationContext, ViewBooks::class.java)
            startActivity(intent)
        }
    }
}