package com.example.school.admin.results

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.school.R
import com.example.school.admin.results.model.ResultsModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddResultsActivity : AppCompatActivity() {
    private lateinit var mar: TextView
    private lateinit var mean: TextView
    private lateinit var ttmrk: TextView

    private lateinit var btnupload: Button
    private lateinit var dbRef: DatabaseReference
    private lateinit var name: TextView
    private lateinit var addmission: TextView
    private lateinit  var math: EditText
    private lateinit var english: EditText
    private lateinit var chemistry: EditText
    private lateinit var kiswahili  : EditText
    private lateinit var cre : EditText
    private lateinit var bst : EditText
    private lateinit var biology  : EditText
    private lateinit var physics : EditText
    private lateinit var history : EditText
    private lateinit var geo : EditText
    private lateinit var computer : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_results)
        supportActionBar?.hide()

        mar= findViewById(R.id.meangrd)
        mean = findViewById(R.id.meanmarks)
        ttmrk = findViewById(R.id.totalmarks)

        name= findViewById(R.id.in_student_name)
        addmission= findViewById(R.id.in_adm_results)
        btnupload = findViewById(R.id.btn_reults_upload)
        math = findViewById(R.id.in_math)
        english = findViewById(R.id.in_english)
        chemistry = findViewById(R.id.in_chemistry)
        kiswahili  = findViewById(R.id.in_kiswahili)
        cre  = findViewById(R.id.in_cre)
        bst  = findViewById(R.id.in_bs)
        biology  = findViewById(R.id.in_biology)
        physics  = findViewById(R.id.in_physics)
        history  = findViewById(R.id.in_history)
        geo  = findViewById(R.id.in_geo)
        computer  = findViewById(R.id.in_computer)
        dbRef = FirebaseDatabase.getInstance().getReference("Results")

        btnupload.setOnClickListener {
            saveResultsData()

        }
    }

    private fun saveResultsData() {
        val name = name.text.toString()
        val admission = addmission.text.toString()
        val math = math.text.toString().trim()
        val english= english.text.toString().trim()
        val chemistry= chemistry.text.toString().trim()
        val kiswahili =kiswahili.text.toString().trim()
        val cre=cre.text.toString().trim()
        val bst= bst.text.toString().trim()
        val biology=biology.text.toString().trim()
        val physics=physics.text.toString().trim()
        val history=history.text.toString().trim()
        val geo=geo.text.toString().trim()
        val computer =computer.text.toString().trim()
        val total = ttmrk.text.toString().trim()
        //doing of the calculations
        //calculate the total marks,mean the assing the meangrade
        val totalmarks =  math.toDouble() + english.toDouble() + chemistry.toDouble()+ kiswahili.toDouble()+ cre.toDouble()+ bst.toDouble()+ biology.toDouble()+ physics.toDouble()+ history.toDouble()+ geo.toDouble()+ computer.toDouble()
        val meanmarks = totalmarks/10
        val  news = arrayListOf("E","D-","D")
        if (meanmarks <= 30.0) {

              mar.text = news[0]
        } else if (meanmarks <= 35.0) {

            mar.text = news[1]
        } else if (meanmarks <= 40) {

            mar.text = news[2]
        } else if (meanmarks <= 45) {

            mar.text = "D+"
        } else if (meanmarks <= 50) {

            mar.text = "C-"
        } else if (meanmarks <= 55) {

            mar.text =  "C"
        } else if (meanmarks <= 60) {

            mar.text = "C+"
        } else if (meanmarks <= 65) {

            mar.text = "B-"
        } else if (meanmarks <= 70) {

            mar.text = "B"
        } else if (meanmarks <= 75) {


            mar.text = "B+"
        } else if (meanmarks <= 80) {

            mar.text = "A-"
        } else if (meanmarks >= 81){

            mar.text = "A"

        }

        val new = mar.text.toString().trim()
        //display it on the screen
        mean.text = meanmarks.toString()
        ttmrk.text = totalmarks.toString()
        val students = ResultsModel(name,admission,math,english,kiswahili,chemistry,cre,physics,bst,biology,computer,history,geo,new)

        dbRef.child(name).setValue(students)
            .addOnCompleteListener {
                Toast.makeText(this,"inserted", Toast.LENGTH_LONG).show()

//dd the clear code

            }.addOnFailureListener {
                Toast.makeText(this, "not inserted", Toast.LENGTH_LONG).show()
            }
    }
}