package com.example.school.libraly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.school.R
import com.example.school.libraly.model.BooksModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class BooksCollection : AppCompatActivity() {
    private lateinit var stdname: EditText
    private lateinit var bkname: EditText
    private lateinit var stdadm: EditText
    private lateinit var bknum: EditText
    private lateinit var givdate: EditText
    private lateinit var cllbk: EditText
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books_collection)
        stdname = findViewById(R.id.name)
        stdadm = findViewById(R.id.std_adm)
        bkname = findViewById(R.id.password)
        bknum = findViewById(R.id.bk_number)
        givdate = findViewById(R.id.edt_given_dt)
        cllbk = findViewById(R.id.edt_cll_date)

        dbRef = FirebaseDatabase.getInstance().getReference("givenbooks")

        findViewById<Button>(R.id.btn_gvout).setOnClickListener {
            upload()
        }
    }
    private fun upload() {
        val name = stdname.text.toString()
        val adm = stdadm.text.toString()
        val book = bkname.text.toString()
        val booknumber = bknum.text.toString()
        val givendt = givdate.text.toString()
        val collectiondate = cllbk.text.toString()

        if (name.isEmpty()){
            stdname.error = "please enter name"
        }
        if (adm.isEmpty()){
            stdadm.error = "please enter student admission"
        }
        if (book.isEmpty()){
            bkname.error = "Please enter book name"
        }
        if ( booknumber.isEmpty()){
            bknum.error = "please enter book number"
        }
        if (givendt.isEmpty()){
            givdate.error = "please enter the giving date"
        }
        if (collectiondate.isEmpty()){
            cllbk.error = "please enter the return date"
        }else {


            val books = BooksModel(name, adm, book, booknumber, givendt, collectiondate)

            dbRef.child(name).setValue(books)
                .addOnCompleteListener {
                    stdname.text.clear()
                    stdadm.text.clear()
                    bkname.text.clear()
                    bknum.text.clear()
                    givdate.text.clear()
                    cllbk.text.clear()
                }

        }
    }
}