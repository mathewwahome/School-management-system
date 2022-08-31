package com.example.school.basaa.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.school.R

class SlideshowFragment : Fragment() {

    private lateinit var mView: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
     mView = inflater.inflate(R.layout.fragment_slideshow, container,false)
        return mView
    }


}