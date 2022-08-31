package com.example.school.parents.contacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import com.example.school.R
import com.example.school.ui.dashboard.DashboardFragment

class Contacts : AppCompatActivity() {
    private lateinit var backBtn: ImageView
    private lateinit var attachpdf:ImageButton
    private lateinit var parentname:EditText
    private lateinit var phone:EditText
    private lateinit var stdname:EditText
    private lateinit var stdadm:EditText
    private lateinit var stdbtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        supportActionBar?.hide()

        backBtn = findViewById(R.id.backBtn)
        attachpdf = findViewById(R.id.attachPdfBtn)
        parentname = findViewById(R.id.parentname)
        phone = findViewById(R.id.parentphone)
        stdadm = findViewById(R.id.studentadm)
        stdname = findViewById(R.id.studentname)
        stdbtn = findViewById(R.id.submitBtn)

        backBtn.setOnClickListener {
            val intent = Intent(this@Contacts, DashboardFragment::class.java)
            startActivity(intent)
        }
    }
}