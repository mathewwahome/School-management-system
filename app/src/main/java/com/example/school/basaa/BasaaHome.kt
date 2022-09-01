package com.example.school.basaa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.school.R
import com.example.school.basaa.viewqr.ViewQr
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlin.system.exitProcess
import android.view.View


class BasaaHome : AppCompatActivity() {
    private lateinit var addfeesp:TextView
    private lateinit var qr:TextView
    private lateinit var log:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_basaa_home)
        addfeesp = findViewById(R.id.add_fees_p)
        qr = findViewById(R.id.qr)
        log = findViewById(R.id.logoutbtnb)
        log.setOnClickListener {
            Firebase.auth.signOut()
            val  intent = Intent(applicationContext, BasaaLogin::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
        addfeesp.setOnClickListener {
            val intent = Intent(applicationContext, FeesActivity::class.java)
            startActivity(intent)
        }
        qr.setOnClickListener {
            val intent = Intent(applicationContext, ViewQr::class.java)
            startActivity(intent)
        }
    }
    fun quitApp(view: View) {
        this@BasaaHome.finish()
        exitProcess(0)
    }
}