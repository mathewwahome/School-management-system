package com.example.school

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.school.admin.AdminSignup
import com.example.school.parents.ParentsActivity
import com.example.school.staff.StaffActivity
import com.example.school.students.StudentActivity
import com.example.school.teacher.Teacher
import com.example.school.teacher.TeacherActivity

class MainActivity : AppCompatActivity() {
    private lateinit var admin:TextView
    private lateinit var staff:TextView
    private lateinit var parent:TextView
    private lateinit var students:TextView
    private lateinit var teachers:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        staff = findViewById(R.id.staff)
        admin = findViewById(R.id.basaa )
        parent = findViewById(R.id.parents)
        students = findViewById(R.id.students)
        teachers = findViewById(R.id.teachers)

        admin.setOnClickListener {
            val admins = Intent(applicationContext, AdminSignup::class.java)
            startActivity(admins)
        }
        staff.setOnClickListener {
            val admins = Intent(applicationContext, StaffActivity::class.java)
            startActivity(admins)
        }
        parent.setOnClickListener {
            val admins = Intent(applicationContext, ParentsActivity::class.java)
            startActivity(admins)
        }
        students.setOnClickListener {
            val admins = Intent(applicationContext, StudentActivity::class.java)
            startActivity(admins)
        }
        teachers.setOnClickListener {
            val teacher = Intent(applicationContext, Teacher::class.java)
            startActivity(teacher)
        }
    }
}