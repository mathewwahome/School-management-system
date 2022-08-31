package com.example.school.teacher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.school.R
import com.google.firebase.auth.FirebaseAuth

class TeacherLogin : AppCompatActivity() {
    private lateinit var edemail: EditText
    private  lateinit var edpassword: EditText
    private lateinit var loginbtn: Button
    private lateinit var noaccoutt: TextView
    private lateinit var  auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.teacher_login)
        supportActionBar?.hide()
        edemail =findViewById(R.id.edemail)
        edpassword = findViewById(R.id.edpassword)
        noaccoutt = findViewById(R.id.dont_have_account)
        loginbtn = findViewById(R.id.btnlog)
        auth= FirebaseAuth.getInstance()

        loginbtn.setOnClickListener {
            login()
        }
        noaccoutt.setOnClickListener {
            val intent = Intent(applicationContext, TeacherSignup::class.java)
            startActivity(intent)
        }
    }
    private fun login() {
        val email=edemail.text.toString()
        val password=edpassword.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()){

            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                if(task.isSuccessful){
                    val intent= Intent(this,TeacherActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }.addOnFailureListener { exception ->
                Toast.makeText(applicationContext,exception.localizedMessage, Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this@TeacherLogin,"No empty field required", Toast.LENGTH_SHORT).show()
        }
    }
}