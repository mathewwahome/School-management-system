package com.example.school.admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.school.R
import com.example.school.admin.subjects.model.ClassesModel
import com.example.school.admin.subjects.model.SubjectsModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ClassesActivity : AppCompatActivity() {
    private lateinit var classname: EditText
    private lateinit var classpopulation: EditText
    private lateinit var classtarget: EditText
    private lateinit var teachersname: EditText
    private lateinit var uploadbtn: Button
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classes)
        supportActionBar?.hide()

        classname= findViewById(R.id.class_name)
        classpopulation= findViewById(R.id.population)
        classtarget= findViewById(R.id.target)
        teachersname= findViewById(R.id.teachers_name)
        uploadbtn= findViewById(R.id.upload_btn)
        dbRef = FirebaseDatabase.getInstance().getReference("classes")


        uploadbtn.setOnClickListener {
            upload()
        }
    }

    private fun upload() {
        val classn = classname.text.toString()
        val population = classpopulation.text.toString()
        val target = classtarget.text.toString()
        val teacher = teachersname.text.toString()
        if (classn.isEmpty()){
            classname.error = "please enter subject name"
        }else if (population.isEmpty()){
            classpopulation.error = "please enter subject description"
        }else if (target.isEmpty()){
            classtarget.error = "please enter subject description"
        }else if (teacher.isEmpty()){
            teachersname.error = "please enter subject description"
        }else{
            val books = ClassesModel(classn, population,target,teacher)

            dbRef.child(classn).setValue(books).addOnCompleteListener {
                classname.text.clear()
                classpopulation.text.clear()
                classtarget.text.clear()
                teachersname.text.clear()
            }
        }
    }
}