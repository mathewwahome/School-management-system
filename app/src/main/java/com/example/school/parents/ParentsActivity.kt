package com.example.school.parents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.school.R
import com.example.school.basaa.upload.FeesUpload
import com.example.school.parents.model.QrModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage

class ParentsActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    private lateinit var viewres: TextView
    private lateinit var sendqr: Button
    private lateinit var stdname: EditText
    private lateinit var getqr: EditText
    private lateinit var dbRef: DatabaseReference
    private lateinit var selectimage: TextView
    private  var feesimage= Firebase.storage
    private lateinit var uri:Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        var payviampesa: TextView?=null

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parents)
        supportActionBar?.hide()
        payviampesa = findViewById(R.id.pay_via_mpesa)
        auth = FirebaseAuth.getInstance()
        viewres = findViewById(R.id.view_std_results)
        sendqr = findViewById(R.id.sendqr)
        stdname = findViewById(R.id.stdname)
        getqr = findViewById(R.id.get_qr)
        selectimage= findViewById(R.id.selectimage)

        feesimage = FirebaseStorage.getInstance()

        dbRef = FirebaseDatabase.getInstance().getReference("Qrcode")

        sendqr.setOnClickListener {
            sendQr()
        }
        viewres.setOnClickListener {
            val intent = Intent(applicationContext, StudentDeActivity::class.java)
            startActivity(intent)
        }

        payviampesa!!.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }
        }

        selectimage.setOnClickListener {
            val intent = Intent(applicationContext, FeesUpload::class.java)
            startActivity(intent)
        }
    }
    private fun sendQr() {
        val name = stdname.text.toString().trim()
        val qr = getqr.text.toString().trim()
        if (stdname.text.isEmpty()){
            stdname.error ="please enter the student name"
        }else if (getqr.text.isEmpty()){
            getqr.error = "please enter the qr"
        }else{
            val users = QrModel(name,qr)
            dbRef.child(name).setValue(users)
                .addOnCompleteListener {
                    Toast.makeText(this,"sent", Toast.LENGTH_LONG).show()
                    stdname.text.clear()
                    getqr.text.clear()
                }.addOnFailureListener {
                    Toast.makeText(this, "not sent", Toast.LENGTH_LONG).show()
                }
        }
    }
}