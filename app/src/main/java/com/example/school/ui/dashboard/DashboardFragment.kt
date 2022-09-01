package com.example.school.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.school.MainActivity
import com.example.school.R
import com.example.school.admin.ClassesActivity
import com.example.school.admin.exam.Exam
import com.example.school.admin.homework.AssignmentActivity
import com.example.school.admin.notice.NoticeActivity
import com.example.school.admin.results.AddResultsActivity
import com.example.school.admin.staff.AddStaff
import com.example.school.admin.students.AddStudentsActivity
import com.example.school.admin.subjects.AddSubjectActivity
import com.example.school.parents.ParentMainActivity
import com.example.school.parents.contacts.Contacts
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class DashboardFragment : Fragment() {
    private lateinit var mview:View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        mview = inflater.inflate(R.layout.fragment_dashboard,container,false)

        mview.findViewById<CardView>(R.id.classes_tap).setOnClickListener {
            val  intent = Intent(this@DashboardFragment.requireContext(), ClassesActivity::class.java)
            startActivity(intent)
        }
        mview.findViewById<CardView>(R.id.subjects_tap).setOnClickListener {
            val  intent = Intent(this@DashboardFragment.requireContext(), AddSubjectActivity::class.java)
            startActivity(intent)
        }
        mview.findViewById<CardView>(R.id.students_tap).setOnClickListener {
            val  intent = Intent(this@DashboardFragment.requireContext(), AddStudentsActivity::class.java)
            startActivity(intent)
        }
        mview.findViewById<CardView>(R.id.results_tap).setOnClickListener {
            val  intent = Intent(this@DashboardFragment.requireContext(), AddResultsActivity::class.java)
            startActivity(intent)
        }
        mview.findViewById<CardView>(R.id.notice_tap).setOnClickListener {
            val  intent = Intent(this@DashboardFragment.requireContext(), NoticeActivity::class.java)
            startActivity(intent)
        }
        mview.findViewById<CardView>(R.id.homework_cardtap).setOnClickListener {
            val  intent = Intent(this@DashboardFragment.requireContext(), AssignmentActivity::class.java)
            startActivity(intent)
        }
        mview.findViewById<CardView>(R.id.staff_tap).setOnClickListener {
            val  intent = Intent(this@DashboardFragment.requireContext(), AddStaff::class.java)
            startActivity(intent)
        }
        mview.findViewById<CardView>(R.id.exam_tap).setOnClickListener {
            val  intent = Intent(this@DashboardFragment.requireContext(), Exam::class.java)
            startActivity(intent)
        }
        mview.findViewById<CardView>(R.id.parents_tap).setOnClickListener {
            val  intent = Intent(this@DashboardFragment.requireContext(), Contacts::class.java)
            startActivity(intent)
        }
        mview.findViewById<Button>(R.id.signOutBtnb).setOnClickListener {
            Firebase.auth.signOut()
            val  intent = Intent(this@DashboardFragment.requireContext(), MainActivity::class.java)
            startActivity(intent)
        }
        return mview
    }
}