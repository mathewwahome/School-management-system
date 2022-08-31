package com.example.school.libraly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.school.R
import com.example.school.libraly.model.AddBookModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddBook : AppCompatActivity() {
    private lateinit var backBtn:ImageView
    private lateinit var titleEt:EditText
    private lateinit var descriptionEt:EditText
    private lateinit var categoryTv:EditText
    private lateinit var submitBtn:Button
    private lateinit var dbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)

        backBtn = findViewById(R.id.backBtn)

        titleEt = findViewById(R.id.parentname)
        descriptionEt = findViewById(R.id.parentphone)
        categoryTv = findViewById(R.id.studentname)
        submitBtn = findViewById(R.id.submitBtn)
        dbRef = FirebaseDatabase.getInstance().getReference("Libbooks")


        backBtn.setOnClickListener {
            val intent = Intent(applicationContext, Libralian::class.java)
            startActivity(intent)
        }
        submitBtn.setOnClickListener {
            upload()
        }
    }

    private fun upload() {
        val bookname = titleEt.text.toString().toLowerCase().trim()
        val description = descriptionEt.text.toString().toLowerCase().trim()
        val category = categoryTv.text.toString().toLowerCase().trim()

        if (bookname.isEmpty()){
            titleEt.error = "please enter name"
        }
        if (description.isEmpty()){
            descriptionEt.error = "please enter student admission"
        }
        if (category.isEmpty()){
            categoryTv.error = "Please enter book name"
        }else {
            val books = AddBookModel(bookname, description, category)

            dbRef.child(bookname).setValue(books).addOnCompleteListener {
                titleEt.text.clear()
                descriptionEt.text.clear()
                categoryTv.text.clear()
            }
        }
    }
}