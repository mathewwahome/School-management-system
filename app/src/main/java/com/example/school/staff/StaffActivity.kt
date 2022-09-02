package com.example.school.staff

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.school.R
import com.example.school.basaa.BasaaActivity
import com.example.school.libraly.Libralian
import kotlin.system.exitProcess
import android.view.View

class StaffActivity : AppCompatActivity() {
    private lateinit var basaa: TextView
    private lateinit var libralian: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff)
        supportActionBar?.hide()
        basaa = findViewById(R.id.basaa)
        libralian = findViewById(R.id.lib)
        basaa.setOnClickListener {
            val intent = Intent(applicationContext, BasaaActivity::class.java)
            startActivity(intent)
        }
        libralian.setOnClickListener {
            val intent = Intent(applicationContext, Libralian::class.java)
            startActivity(intent)
        }
    }
    fun quitApp(view: View) {
        this@StaffActivity.finish()
        finishAffinity()
    }
}