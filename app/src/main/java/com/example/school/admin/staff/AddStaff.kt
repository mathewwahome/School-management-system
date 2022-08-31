package com.example.school.admin.staff

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.school.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class AddStaff : AppCompatActivity() {
    private lateinit var database : DatabaseReference
    private lateinit var firstname: EditText
    private lateinit var lastname: EditText
    private lateinit var sage: EditText
    private lateinit var username: EditText
    private lateinit var view: Button
    private lateinit var update: Button
    private lateinit var registerBtn:Button
//    val database = Firebase.database
//    val myRef = database.getReference("message")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_staff)
        supportActionBar?.hide()

        registerBtn= findViewById(R.id.registerBtn)
        firstname = findViewById(R.id.firstName)
        lastname = findViewById(R.id.lastName)
        sage = findViewById(R.id.age)
        username = findViewById(R.id.userName)
        view = findViewById(R.id.view_btn_dt)
        update = findViewById(R.id.update)

        update.setOnClickListener {
            val intent = Intent(applicationContext, UpdateData::class.java)
            startActivity(intent)
        }
        view.setOnClickListener {
            val intent = Intent(applicationContext, ReadData::class.java)
            startActivity(intent)
        }




        registerBtn.setOnClickListener {

            val firstName = firstname.text.toString()
            val lastName = lastname.text.toString()
            val age = sage.text.toString()
            val userName = username.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Staff")
            val user = User(firstName,lastName,age,userName)
            database.child(userName).setValue(user).addOnSuccessListener {

                firstname.text.clear()
                lastname.text.clear()
                sage.text.clear()
                username.text.clear()

                Toast.makeText(this,"Successfully Saved", Toast.LENGTH_SHORT).show()

            }.addOnFailureListener{

                Toast.makeText(this,"Failed", Toast.LENGTH_SHORT).show()


            }


        }
    }
}