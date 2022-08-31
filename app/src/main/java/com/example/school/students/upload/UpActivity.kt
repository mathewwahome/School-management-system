package com.example.school.students.upload

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.school.R
import com.google.firebase.storage.FirebaseStorage
import java.text.SimpleDateFormat
import java.util.*

class UpActivity : AppCompatActivity() {
    private lateinit var upload:Button
    private lateinit var select:Button
    private lateinit var firebaseimage:ImageView
    private lateinit var ImageUri :Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_up)
        upload = findViewById(R.id.upload_btn)
        select = findViewById(R.id.select_btn)
        firebaseimage = findViewById(R.id.firebaseimage)

        select.setOnClickListener {
            selectImage()
        }
        upload.setOnClickListener {
            uploadImage()
        }
    }

    private fun uploadImage() {
//        show the progress dialog
        val progression = ProgressDialog(this)
        progression.setMessage("uploading file ...")
        progression.setCancelable(false)
        progression.show()

        val formatter = SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault())
        val now = Date()
        val fileName = formatter.format(now)
        val storageReference = FirebaseStorage.getInstance().getReference("images/$fileName")

        storageReference.putFile(ImageUri).
                addOnSuccessListener {
                    firebaseimage.setImageURI(null)
                    Toast.makeText(this@UpActivity,"Uploaded", Toast.LENGTH_SHORT).show()
                    if (progression.isShowing)progression.dismiss()

                }.addOnFailureListener{
                    if (progression.isShowing)progression.dismiss()
                    Toast.makeText(this@UpActivity,"Not Uploaded", Toast.LENGTH_SHORT).show()
        }
    }
    private fun selectImage() {
        val intent = Intent()
        intent.type= "images/*"
        intent.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(
            intent,
            100
        )

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK){

            ImageUri = data?.data!!
            firebaseimage.setImageURI(ImageUri)
        }

    }
}