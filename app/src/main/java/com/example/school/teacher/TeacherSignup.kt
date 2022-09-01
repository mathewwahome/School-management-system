package com.example.school.teacher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.school.R
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth

class TeacherSignup : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var name: EditText
    private lateinit var email: EditText
    private lateinit var passwrd: EditText
    private lateinit var passwordone: EditText
    private lateinit var btnsignup: Button
    private lateinit var logintxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.teacher_signup)
        supportActionBar?.hide()
        firebaseAuth = FirebaseAuth.getInstance()
        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        passwrd = findViewById(R.id.password)
        passwordone = findViewById(R.id.repassword)
        btnsignup = findViewById(R.id.reg_btn)
        logintxt = findViewById(R.id.ihave_account_txt)


        logintxt.setOnClickListener {
            val intent = Intent(applicationContext, TeacherLogin::class.java)
            startActivity(intent)
        }
        btnsignup.setOnClickListener {
            val email =name.text.toString()
            val password = passwrd.text.toString()
            val confirmPass = passwordone.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (password == confirmPass) {

                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful) {

                            val intent = Intent(this, TeacherLogin::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                        }
                    }
                } else {
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }
        }
    }
}