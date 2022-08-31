package com.example.school.admin.homework

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.school.R
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask

class AssignmentActivity : AppCompatActivity() {
    private lateinit var pdf: Button
    private lateinit var docx: Button
    private lateinit var music: Button
    private lateinit var video: Button
    val PDF : Int = 0
    val DOCX : Int = 1
    val AUDIO : Int = 2
    val VIDEO : Int = 3
    lateinit var uri : Uri
    lateinit var mStorage : StorageReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assignment)
        supportActionBar?.hide()
        pdf = findViewById<View>(R.id.upload_pdf)as Button
        docx = findViewById<View>(R.id.upload_docx)as Button
        music = findViewById<View>(R.id.btn_music)as Button
        video = findViewById<View>(R.id.btn_video)as Button

        mStorage = FirebaseStorage.getInstance().getReference("Uploadfile")

        pdf.setOnClickListener {
            val intent = Intent()
            intent.type = "pdf/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select PDF"), PDF)
        }
        docx.setOnClickListener {
            val intent = Intent()
            intent.type = "docx/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select DOCX"), DOCX)
        }
        music.setOnClickListener {
            val intent = Intent()
            intent.type = "audio/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select Audio"), AUDIO)
        }
        video.setOnClickListener {
            val intent = Intent()
            intent.type = "video/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select Video"), VIDEO)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val uriTxt = findViewById<View>(R.id.uriTxt) as TextView
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                PDF -> {
                    uri = data!!.data!!
                    uriTxt.text = uri.toString()
                    upload ()
                }
                DOCX -> {
                    uri = data!!.data!!
                    uriTxt.text = uri.toString()
                    upload ()
                }
                AUDIO -> {
                    uri = data!!.data!!
                    uriTxt.text = uri.toString()
                    upload ()
                }
                VIDEO -> {
                    uri = data!!.data!!
                    uriTxt.text = uri.toString()
                    upload ()
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun upload() {
        val mReference = mStorage.child(uri.lastPathSegment!!)
        try {
            mReference.putFile(uri).addOnSuccessListener {
                    taskSnapshot: UploadTask.TaskSnapshot? ->
                val dwnTxt = findViewById<View>(R.id.dwnTxt) as TextView
                dwnTxt.text = taskSnapshot.toString()
                Toast.makeText(this, "Successfully Uploaded", Toast.LENGTH_LONG).show()
            }
        }catch (e: Exception) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
        }

    }
}