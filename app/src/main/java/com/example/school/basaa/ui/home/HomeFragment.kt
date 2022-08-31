package com.example.school.basaa.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.school.R
import com.example.school.basaa.FeesActivity

class HomeFragment : Fragment() {

    private lateinit var mView: View
    private lateinit var addfees:TextView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mView = inflater.inflate(R.layout.basaa_home_fragment, container,false)
        addfees = mView.findViewById(R.id.add_fees)

        addfees.setOnClickListener {
            val intent = Intent(this@HomeFragment.requireContext(), FeesActivity::class.java)
            startActivity(intent)
        }



        return mView
    }

}

