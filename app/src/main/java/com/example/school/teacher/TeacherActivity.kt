package com.example.school.teacher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.school.R
import com.example.school.admin.homework.AssignmentActivity

class TeacherActivity : AppCompatActivity() {
    private lateinit var uploadassignment:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)
        supportActionBar?.hide()
        uploadassignment = findViewById(R.id.assignment)

        uploadassignment.setOnClickListener { 
            val intent = Intent(applicationContext, AssignmentActivity::class.java)
            startActivity(intent)
        }
    }
}