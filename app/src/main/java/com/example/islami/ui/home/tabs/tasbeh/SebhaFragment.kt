package com.example.islami.ui.home.tabs.tasbeh

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami.R
import com.example.islami.databinding.FragmentQuranBinding
import com.example.islami.databinding.FragmentRadioBinding
import com.example.islami.databinding.FragmentSebhaBinding


class SebhaFragment : Fragment() {
    lateinit var viewBinding: FragmentSebhaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentSebhaBinding.inflate(inflater,container,false)
        return viewBinding.root
    }
}