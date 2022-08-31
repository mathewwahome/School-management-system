package com.example.school.admin.notice

import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.school.R
import com.example.school.databinding.ActivityNoticeBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NoticeActivity : AppCompatActivity() {

    private lateinit var noticetypebtn: RadioGroup
    private lateinit var fabe:FloatingActionButton
    private lateinit var noticetype:TextView
    private lateinit var party:TextView
    private lateinit var selectparty:RadioGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice)
        fabe = findViewById(R.id.fab)
        noticetype = findViewById(R.id.noticetype)
        selectparty = findViewById(R.id.selectparty)
        noticetypebtn = findViewById(R.id.noticetypebtn)
        party = findViewById(R.id.party)


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































        fabe.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
        }
    }
}