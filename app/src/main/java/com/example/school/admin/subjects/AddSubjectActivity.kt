package com.example.school.admin.subjects

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.school.R
import com.example.school.admin.subjects.model.SubjectsModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddSubjectActivity : AppCompatActivity() {
    private lateinit var sbjname: EditText
    private lateinit var sbjdesc: EditText
    private lateinit var btnupload: TextView
    private lateinit var buttonsec: ImageView
    private lateinit var dbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_subject)
        sbjname = findViewById(R.id.sbj_name)
        sbjdesc = findViewById(R.id.sbj_desc)
        btnupload= findViewById(R.id.btn_upload)
        buttonsec = findViewById(R.id.buttonSecond)

        dbRef = FirebaseDatabase.getInstance().getReference("subjects")

        btnupload.setOnClickListener {
            upload()
        }
    }

    private fun upload() {
        val name = sbjname.text.toString()
        val desc = sbjdesc.text.toString()
        if (name.isEmpty()){
            sbjname.error = "please enter subject name"
        }else if (desc.isEmpty()){
            sbjdesc.error = "please enter subject description"
        }else{
            val books = SubjectsModel(name, desc)

            dbRef.child(name).setValue(books).addOnCompleteListener {
                sbjname.text.clear()
                sbjdesc.text.clear()
            }
        }
    }
}