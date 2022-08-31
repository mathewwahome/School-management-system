package com.example.school.libraly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.school.R
import com.example.school.libraly.model.AddBookModel
import com.example.school.libraly.model.LibStudentsModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegLibStudents : AppCompatActivity() {
    private lateinit var backBtn:ImageView
    private lateinit var year:EditText
    private lateinit var studentname:EditText
    private lateinit var studentadm:EditText
    private lateinit var register:Button
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg_lib_students)
        backBtn = findViewById(R.id.backBtn)
        year = findViewById(R.id.year)
        studentname = findViewById(R.id.studentname)
        studentadm = findViewById(R.id.studentadm)
        register = findViewById(R.id.btnregister)
        dbRef = FirebaseDatabase.getInstance().getReference("librstudents")

        register.setOnClickListener {
            registernow()
        }
        backBtn.setOnClickListener {
            val intent = Intent(applicationContext, Libralian::class.java)
            startActivity(intent)
        }
    }

    private fun registernow() {
        val date = year.text.toString().toLowerCase().trim()
        val name = studentname.text.toString().toLowerCase().trim()
        val adm = studentadm.text.toString().toLowerCase().trim()

        if (date.isEmpty()){
            year.error = "please enter year"
        }
        if (name.isEmpty()){
            studentname.error = "please enter student name"
        }
        if (adm.isEmpty()){
            studentadm.error = "Please enter book admission"
        }else {
            val books = LibStudentsModel(date, name, adm)

            dbRef.child(adm).setValue(books).addOnCompleteListener {
                year.text.clear()
                studentadm.text.clear()
                studentname.text.clear()
            }
        }
    }
}