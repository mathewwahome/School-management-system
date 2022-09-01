package com.example.school.parents.contacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.school.R
import com.example.school.parents.contacts.model.ContactsModel
import com.example.school.ui.dashboard.DashboardFragment
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Contacts : AppCompatActivity() {
    private lateinit var backBtn: ImageView
    private lateinit var attachpdf:ImageButton
    private lateinit var parentname:EditText
    private lateinit var phone:EditText
    private lateinit var stdname:EditText
    private lateinit var stdadm:EditText
    private lateinit var stdbtn:Button
    private lateinit var dbRef: DatabaseReference

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

        dbRef = FirebaseDatabase.getInstance().getReference("Contacts")
        stdbtn = findViewById(R.id.submitBtn)

        stdbtn.setOnClickListener {
            val namep = parentname.text.toString().trim().lowercase()
            val nanestd = stdname.text.toString().trim().lowercase()
            val admstd = stdadm.text.toString().trim().lowercase()
            val phn = phone.text.toString().trim().lowercase()
            if (namep.isEmpty()){
                parentname.error = "please enter parent name"
            }else if (nanestd.isEmpty()){
                stdname.error = "please enter student name"
            }else if (admstd.isEmpty()){
                stdadm.error = "please enter student adm"
            }else if (phn.isEmpty()){
                phone.error = "please enter phonenumber"
            }else{
                val contacts = ContactsModel(namep, nanestd,admstd,phn)

                dbRef.child(namep).setValue(contacts).addOnCompleteListener {

                    Toast.makeText(this, "Contact Successfully Uploaded", Toast.LENGTH_LONG).show()
                    parentname.text.clear()
                    stdname.text.clear()
                    stdadm.text.clear()
                    phone.text.clear()
                }.addOnFailureListener {
                    Toast.makeText(this, "Contact not added", Toast.LENGTH_LONG).show()
                }
            }
        }



















        backBtn.setOnClickListener {
            val intent = Intent(this@Contacts, DashboardFragment::class.java)
            startActivity(intent)
        }
    }
}