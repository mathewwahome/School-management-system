package com.example.school.basaa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.school.R

class FeesActivity : AppCompatActivity() {

    private lateinit var name:EditText
    private lateinit var adm:EditText
    private lateinit var paymentbtn:Button
    private lateinit var amount:EditText
    private lateinit var date:EditText
    private lateinit var paymentmethod:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fees)
        supportActionBar?.hide()

        name = findViewById(R.id.stdname)
        adm = findViewById(R.id.stdadm)
        paymentbtn = findViewById(R.id.payfees)
        paymentmethod = findViewById(R.id.modeofpayment)
        date = findViewById(R.id.paymentdate)
        amount = findViewById(R.id.amount)

        paymentbtn.setOnClickListener {
            uploadfees()
        }
    }

    private fun uploadfees() {
        TODO("Not yet implemented")
    }
}