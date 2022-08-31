package com.example.school.teacher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.school.R

class Teacher : AppCompatActivity() {

    private lateinit var signin:TextView
    private lateinit var signup:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.teacher_activity)
        signin = findViewById(R.id.login)
        signup = findViewById(R.id.register)

        signin.setOnClickListener {
            val login = Intent(applicationContext, TeacherLogin::class.java)
            startActivity(login)
        }
        signup.setOnClickListener {
            val register = Intent(applicationContext, TeacherSignup::class.java)
            startActivity(register)
        }
    }
}