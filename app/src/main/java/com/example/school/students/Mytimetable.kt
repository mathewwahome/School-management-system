package com.example.school.students

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.school.R
import com.example.school.admin.students.model.TimeModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlin.math.sqrt

class Mytimetable : AppCompatActivity() {
    private lateinit var fab:FloatingActionButton
    private lateinit var dbRef: DatabaseReference
    private lateinit var btntimetable:TextView
    private lateinit var adm:EditText

    private lateinit var a: EditText
    private lateinit var b: EditText
    private lateinit var c: EditText
    private lateinit var d: EditText
    private lateinit var e: EditText
    private lateinit var f: EditText
    private lateinit var g: EditText
    private lateinit var h: EditText
    private lateinit var i: EditText
    private lateinit var j: EditText
    private lateinit var da: EditText
    private lateinit var ca: EditText
    private lateinit var baa: EditText
    private lateinit var aa: EditText
    private lateinit var z: EditText
    private lateinit var y: EditText
    private lateinit var x: EditText
    private lateinit var w: EditText
    private lateinit var v: EditText
    private lateinit var u: EditText
    private lateinit var t: EditText
    private lateinit var s: EditText
    private lateinit var r: EditText
    private lateinit var q: EditText
    private lateinit var p: EditText
    private lateinit var o: EditText
    private lateinit var n: EditText
    private lateinit var m: EditText
    private lateinit var l: EditText
    private lateinit var k: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mytimetable)
        supportActionBar?.hide()
        fab = findViewById(R.id.fab)
        dbRef = FirebaseDatabase.getInstance().getReference("TimetableS")

        btntimetable = findViewById(R.id.btntimetable)
        adm = findViewById(R.id.adm)

        a = findViewById(R.id.a)
        b= findViewById(R.id.b)
        c= findViewById(R.id.c)
        d= findViewById(R.id.za)
        e= findViewById(R.id.d)
        f= findViewById(R.id.e)

        g= findViewById(R.id.f)
        h= findViewById(R.id.g)
        i= findViewById(R.id.h)
        j= findViewById(R.id.i)
        k= findViewById(R.id.j)
        l= findViewById(R.id.k)

        m= findViewById(R.id.l)
        n= findViewById(R.id.ah)
        o= findViewById(R.id.n)
        p= findViewById(R.id.o)
        q= findViewById(R.id.p)
        r= findViewById(R.id.r)

        s= findViewById(R.id.ar)
        t= findViewById(R.id.s)
        u= findViewById(R.id.t)
        v= findViewById(R.id.u)
        w= findViewById(R.id.v)
        x= findViewById(R.id.w)

        y= findViewById(R.id.x)
        z= findViewById(R.id.y)
        aa= findViewById(R.id.z)
        baa= findViewById(R.id.aa)
        ca= findViewById(R.id.ba)
        da= findViewById(R.id.ca)




        btntimetable.setOnClickListener {
            saveResultsData()

        }

        fab.setOnClickListener {
            val intent = Intent(applicationContext, StudentActivity::class.java)
            startActivity(intent)
        }

    }

    private fun saveResultsData() {

        val ba = a.text.toString().trim().lowercase()
        val bc = b.text.toString().trim().lowercase()
        val bd = c.text.toString().trim().lowercase()
        val xh = d.text.toString().trim().lowercase()
        val bi = e.text.toString().trim().lowercase()
        val ob = f.text.toString().trim().lowercase()

        val bz = g.text.toString().trim().lowercase()
        val gg = h.text.toString().trim().lowercase()
        val mg = i.text.toString().trim().lowercase()
        val vv = j.text.toString().trim().lowercase()
        val mh = k.text.toString().trim().lowercase()
        val bq = l.text.toString().trim().lowercase()

        val mj = m.text.toString().trim().lowercase()
        val ki = n.text.toString().trim().lowercase()
        val gf = o.text.toString().trim().lowercase()
        val vf = p.text.toString().trim().lowercase()
        val vg = q.text.toString().trim().lowercase()
        val bbi = r.text.toString().trim().lowercase()

        val id = s.text.toString().trim().lowercase()
        val lo = t.text.toString().trim().lowercase()
        val ll = u.text.toString().trim().lowercase()
        val li = v.text.toString().trim().lowercase()
        val ko = w.text.toString().trim().lowercase()
        val be = x.text.toString().trim().lowercase()

        val bf = y.text.toString().trim().lowercase()
        val mk = z.text.toString().trim().lowercase()
        val bh = aa.text.toString().trim().lowercase()
        val bj = baa.text.toString().trim().lowercase()
        val mn = ca.text.toString().trim().lowercase()
        val mm = da.text.toString().trim().lowercase()

        val admi = adm.text.toString().trim().lowercase()
        val upload = TimeModel(admi,ba,bc,bd,xh,bi,ob,bz,gg,mg,vv,mh,bq,mj,ki,gf,vf,vg,bbi,id,lo,ll,li,ko,be,bf,mk,bh,bj,mn,mm)

        if (admi.isNotEmpty()){
            dbRef.child(admi).setValue(upload)
                .addOnCompleteListener {
                    Toast.makeText(this,"inserted", Toast.LENGTH_LONG).show()

//dd the clear code

                }.addOnFailureListener {
                    Toast.makeText(this, "not inserted", Toast.LENGTH_LONG).show()
                }
        }else{
            Toast.makeText(this,"fill in adm", Toast.LENGTH_LONG).show()
        }

    }
}