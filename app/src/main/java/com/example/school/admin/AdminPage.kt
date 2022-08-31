package com.example.school.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.school.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AdminPage : AppCompatActivity() {
    private lateinit var logout:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_page)
        logout = findViewById(R.id.logout)

        logout.setOnClickListener {
            Firebase.auth.signOut()

            val intent = Intent(applicationContext, AdminLogin::class.java)
            startActivity(intent)
        }
    }
}