package com.example.school.basaa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.school.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class BasaaLogin : AppCompatActivity() {
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var logbtn: Button
    private lateinit var auth: FirebaseAuth
    private lateinit var noaccount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basaa_login)
        supportActionBar?.hide()

        email = findViewById(R.id.edemail)
        password = findViewById(R.id.edpassword)
        logbtn = findViewById(R.id.btnlog)
        noaccount = findViewById(R.id.dont_have_account)
        auth = Firebase.auth

        noaccount.setOnClickListener {
            val intent = Intent(applicationContext, SignupActivity::class.java)
            startActivity(intent)
        }
        logbtn.setOnClickListener {
            loginfun()
        }
    }
    private fun loginfun() {
        val aemail = email.text.toString().lowercase().trim()
        val apassword = password.text.toString().lowercase().trim()

        if (aemail.isNotEmpty() && apassword.isNotEmpty()){
            auth.signInWithEmailAndPassword(aemail, apassword)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        updateUI()
                    } else {
                        Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT).show()
                    }
                }
        }else{
            Toast.makeText(baseContext, "No Empty fields Required.", Toast.LENGTH_SHORT).show()
        }
    }
    private fun updateUI() {
        val intent = Intent(applicationContext, BasaaHome::class.java)
        startActivity(intent)
    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            updateUI()
        }
    }
}