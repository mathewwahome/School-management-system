package com.example.school.basaa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.school.R
import com.example.school.basaa.viewqr.ViewQr

class BasaaHome : AppCompatActivity() {
    private lateinit var addfeesp:TextView
    private lateinit var qr:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basaa_home)
        addfeesp = findViewById(R.id.add_fees_p)
        qr = findViewById(R.id.qr)
        addfeesp.setOnClickListener {
            val intent = Intent(applicationContext, FeesActivity::class.java)
            startActivity(intent)
        }
        qr.setOnClickListener {
            val intent = Intent(applicationContext, ViewQr::class.java)
            startActivity(intent)
        }
    }
}