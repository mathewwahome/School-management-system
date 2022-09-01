package com.example.school.admin.notice

import android.os.Bundle
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.school.R
import com.example.school.admin.notice.mode.NoticeMode
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class NoticeActivity : AppCompatActivity() {
    private lateinit var dbRef: DatabaseReference

    private lateinit var noticetypebtn: RadioGroup
    private lateinit var fabe:FloatingActionButton
    private lateinit var noticetype:TextView
    private lateinit var party:TextView
    private lateinit var selectparty:RadioGroup
    private lateinit var sendbtn:Button
    private lateinit var sms:EditText
    private lateinit var date:CalendarView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice)
        fabe = findViewById(R.id.fab)
        noticetype = findViewById(R.id.noticetype)
        selectparty = findViewById(R.id.selectparty)
        noticetypebtn = findViewById(R.id.noticetypebtn)
        party = findViewById(R.id.party)
        sms = findViewById(R.id.notice_sms)
        sendbtn = findViewById(R.id.sendbtn)
        date = findViewById(R.id.datenotice)
        dbRef = FirebaseDatabase.getInstance().getReference("Notice")


        noticetypebtn.setOnCheckedChangeListener { _, i ->
            val rb = findViewById<RadioButton>(i)
            if (rb != null)
                noticetype.text = rb.text.toString()
        }
        selectparty.setOnCheckedChangeListener { _, i ->

            val new = findViewById<RadioButton>(i)
            if (new != null)
                party.text = new.text.toString()
        }
        sendbtn.setOnClickListener {
            sendnotice()
        }
        fabe.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
        }
    }

    private fun sendnotice() {
        val type = noticetype.text.toString()
        val part = party.text.toString()
        val notice = sms.text.toString().trim()
        val datenote= date.toString()

        val notices = NoticeMode(type,part,notice, datenote)

        dbRef.child(part).setValue(notices)
            .addOnCompleteListener {
                Toast.makeText(this,"Notice sent", Toast.LENGTH_LONG).show()

//dd the clear code

            }.addOnFailureListener {
                Toast.makeText(this, "Notice not sent", Toast.LENGTH_LONG).show()
            }
    }
}