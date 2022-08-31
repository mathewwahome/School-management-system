package com.example.school.libraly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.school.R

class Libralian : AppCompatActivity() {
    private lateinit var oky:TextView
    private lateinit var addbook:TextView
    private lateinit var studentr:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_libralian)
        supportActionBar?.hide()
        oky = findViewById(R.id.oky)
        addbook = findViewById(R.id.addbook)
        studentr = findViewById(R.id.studentr)

        oky.setOnClickListener {
            val intent = Intent(applicationContext, BooksCollection::class.java)
            startActivity(intent)
        }
        studentr.setOnClickListener {
            val intent = Intent(applicationContext, RegLibStudents::class.java)
            startActivity(intent)
        }
        addbook.setOnClickListener {
            val intent = Intent(applicationContext, AddBook::class.java)
            startActivity(intent)
        }
    }
}