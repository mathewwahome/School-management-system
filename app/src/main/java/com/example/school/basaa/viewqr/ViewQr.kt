package com.example.school.basaa.viewqr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.school.R
import com.google.firebase.database.*

class ViewQr : AppCompatActivity() {
    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerview : RecyclerView
    private lateinit var userArraylist : ArrayList<Qr>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_qr)
        supportActionBar?.hide()
        userRecyclerview = findViewById(R.id.userList)
        userRecyclerview.layoutManager = LinearLayoutManager(this)
        userRecyclerview.setHasFixedSize(true)

        userArraylist = arrayListOf()
        getUserData()
    }

    private fun getUserData() {
        dbref = FirebaseDatabase.getInstance().getReference("Qrcode")

        dbref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){

                    for (userSnapshot in snapshot.children){


                        val user = userSnapshot.getValue(Qr::class.java)
                        userArraylist.add(user!!)

                    }

                    userRecyclerview.adapter = MyAdapter(userArraylist)


                }else{
                    Toast.makeText(this@ViewQr, "No data found", Toast.LENGTH_LONG).show()
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
    }
}