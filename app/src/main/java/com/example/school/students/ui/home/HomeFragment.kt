package com.example.school.students.ui.home

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.school.R
import com.example.school.parents.StudentDeActivity
import com.example.school.students.Mytimetable
import com.example.school.students.upload.UpActivity

class HomeFragment : Fragment() {
    private lateinit var mView: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        mView = inflater.inflate(R.layout.student_home, container,false)
        mView.findViewById<TextView>(R.id.takepick).setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)

        }


        mView.findViewById<TextView>(R.id.view_my_results).setOnClickListener {
            val intent= Intent(activity, StudentDeActivity::class.java)
            startActivity(intent)
        }
        mView.findViewById<TextView>(R.id.upload).setOnClickListener {
            val intent= Intent(activity, UpActivity::class.java)
            startActivity(intent)
        }
        mView.findViewById<TextView>(R.id.timetable).setOnClickListener {
            val intent= Intent(activity, Mytimetable::class.java)
            startActivity(intent)
        }
        return mView
    }


}