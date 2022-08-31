package com.example.school.parents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.school.R

class ParentMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var login : TextView?=null
        var signup : TextView?=null
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_parent_main)

        login = findViewById(R.id.logintext)
        signup = findViewById(R.id.signuptext)

        login!!.setOnClickListener {
            val intentlogin = Intent(applicationContext, ParentLoginActivity::class.java)
            startActivity(intentlogin)
        }
        signup!!.setOnClickListener {
            val intent = Intent(applicationContext, ParentSignupActivity::class.java)
            startActivity(intent)
        }
    }
}