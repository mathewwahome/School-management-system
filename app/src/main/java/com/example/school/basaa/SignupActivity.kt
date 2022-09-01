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
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignupActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    private lateinit var name: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var passwordone: EditText
    private lateinit var regbtn: Button
    private lateinit var logintext: TextView
    private lateinit var fogtpass: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.hide()
        fogtpass = findViewById(R.id.forgot_ps)
        logintext= findViewById(R.id.ihave_account_txt)
        name= findViewById(R.id.name)
        email= findViewById(R.id.email)
        password= findViewById(R.id.password)
        passwordone= findViewById(R.id.pass)
        regbtn = findViewById(R.id.reg_btn)
        // Initialize Firebase Auth
        auth = Firebase.auth
        logintext.setOnClickListener {
            val intent = Intent(applicationContext, BasaaLogin::class.java)
            startActivity(intent)
        }
        fogtpass.setOnClickListener {
            val intent = Intent(applicationContext, BasaaHome::class.java)
            startActivity(intent)
        }
        regbtn.setOnClickListener {
            savedata()
        }
    }
    private fun savedata() {
        val pname = name.text.toString().lowercase().trim()
        val pemail = email.text.toString().lowercase().trim()
        val ppassword = password.text.toString().lowercase().trim()
        val ppass = passwordone.text.toString().lowercase().trim()

        if (pname.isEmpty()) {
            name.error = "please enter name"
        } else if (pemail.isEmpty()) {
            email.error = "please enter email"
        } else if (ppassword.isEmpty()) {
            password.error = "please enter a password"
        } else if (ppassword != ppass) {
            passwordone.error = "Please match the password"
        } else if (ppass.isEmpty()) {
            passwordone.error = "please enter a confirmation password"
        } else {
            auth.createUserWithEmailAndPassword(pemail, ppassword)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val user = auth.currentUser
                        updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
//                        updateUI(null)
                    }
                }
        }
    }

    private fun updateUI(user: FirebaseUser?) {
        val intent = Intent(applicationContext, BasaaLogin::class.java)
        startActivity(intent)
    }

}