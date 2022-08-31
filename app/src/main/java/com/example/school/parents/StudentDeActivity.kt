package com.example.school.parents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.school.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class StudentDeActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    private lateinit var readedata: Button
    private lateinit var stdname: EditText
    private lateinit var gt: TextView
    private lateinit var gtt: TextView
    private lateinit var eng: TextView
    private lateinit var kiswa: TextView
    private lateinit var chem: TextView
    private lateinit var phy: TextView
    private lateinit var bio: TextView
    private lateinit var geo: TextView
    private lateinit var cr: TextView
    private lateinit var histo: TextView
    private lateinit var comp: TextView
    private lateinit var mth: TextView
    private lateinit var bst: TextView
    private lateinit var adm: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_de)

        supportActionBar?.hide()
        readedata = findViewById(R.id.readdataBtnm)
        stdname = findViewById(R.id.unames)
        gt = findViewById(R.id.tvFirstName)
        gtt = findViewById(R.id.tvAge)

        eng = findViewById(R.id.eng)
        kiswa= findViewById(R.id.kiswa)
        chem= findViewById(R.id.chem)
        phy = findViewById(R.id.phy)
        bio= findViewById(R.id.bio)
        geo= findViewById(R.id.geo)
        cr= findViewById(R.id.cre)
        histo= findViewById(R.id.histo)
        comp= findViewById(R.id.comp)
        mth= findViewById(R.id.math)
        bst= findViewById(R.id.bst)
        adm = findViewById(R.id.adm)

        readedata.setOnClickListener {
            val studentname = stdname.text.toString().lowercase().trim()
            val admm = adm.text.toString().trim()

            if (studentname.isNotEmpty() || admm.isNotEmpty()) {
                readeData(studentname)
            } else {
                Toast.makeText(this, "Please enter studentdetails", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun readeData(studentname: String) {

        database = FirebaseDatabase.getInstance().getReference("Results")
        database.child(studentname).get().addOnSuccessListener {

            if (it.exists()) {
                val addmision = it.child("admission").value
                val  biology = it.child("biology").value
                val bustness = it.child("business").value
                val chemistry = it.child("chemistry").value
                val computer = it.child("computer").value
                val cre = it.child("cre").value
                val english = it.child("english").value
                val geogrpy = it.child("geo").value
                val history= it.child("history").value
                val kiswahili= it.child("kiswahili").value
                val math= it.child("math").value
                val physics = it.child("physics").value
                val nameof = it.child("name").value

                Toast.makeText(this, "Check out your results", Toast.LENGTH_SHORT).show()

                stdname.text.clear()
                adm.text.clear()

                eng .text= english.toString()
                kiswa.text= kiswahili.toString()
                chem.text= chemistry.toString()
                phy .text= physics.toString()
                bio.text= biology.toString()
                geo.text= geogrpy.toString()
                cr.text= cre.toString()
                histo.text= history.toString()
                comp.text= computer.toString()
                mth.text= math.toString()
                bst.text= bustness.toString()
                gt.text = nameof.toString()
                gtt.text = addmision.toString()
            } else {
                Toast.makeText(this, "User Doesn't Exist", Toast.LENGTH_SHORT).show()
            }
        }
    }
}