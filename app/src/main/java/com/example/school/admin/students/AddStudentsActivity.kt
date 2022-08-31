package com.example.school.admin.students

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.school.R
import com.example.school.admin.students.model.StudentDataModel
import com.example.school.admin.students.viewdb.ViewStdActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddStudentsActivity : AppCompatActivity() {
    private lateinit var uname: EditText
    private lateinit var admno: EditText
    private lateinit var stdclass: EditText
    private lateinit var from: EditText
    private lateinit var towhen: EditText
    private lateinit var btnadd: Button
    private lateinit var btnview: Button
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_students)
        supportActionBar?.hide()
        uname = findViewById(R.id.in_name)
        admno = findViewById(R.id.in_adm)
        stdclass= findViewById(R.id.in_class)
        from= findViewById(R.id.in_from)
        towhen = findViewById(R.id.in_towhen)
        btnadd = findViewById(R.id.btnaddbook)
        btnview= findViewById(R.id.btn_view)
        dbRef = FirebaseDatabase.getInstance().getReference("Students")

        btnadd.setOnClickListener {
            saveUserData()
        }
        btnview.setOnClickListener{
            val viewintent = Intent(applicationContext, ViewStdActivity::class.java)
            startActivity(viewintent)
        }
    }

    private fun saveUserData() {
        val sname = uname.text.toString()
        val sadm = admno.text.toString()
        val sclass = stdclass.text.toString()
        val sfrom = from.text.toString()
        val stowhen = towhen.text.toString()

        if (sname.isEmpty()){
            uname.error = "please enter the student name"
        }
        if (sadm.isEmpty()){
            admno.error = "please enter the student number"
        }
        if (sclass.isEmpty()){
            stdclass.error = "please enter the student current class"
        }
        if (sfrom.isEmpty()){
            from.error = "please enter the entry year"
        }
        if (stowhen.isEmpty()){
            towhen.error = "please enter the left  year"
        }else {
            val users = StudentDataModel(sname, sadm, sclass, sfrom, stowhen)

            dbRef.child(sname).setValue(users)
                .addOnCompleteListener {
                    Toast.makeText(this, "Student added", Toast.LENGTH_LONG).show()

                    uname.text.clear()
                    admno.text.clear()
                    stdclass.text.clear()
                    from.text.clear()
                    towhen.text.clear()

                }.addOnFailureListener { err ->
                    Toast.makeText(this, "Student not added", Toast.LENGTH_LONG).show()
                }
        }    }
}