package com.example.islami.ui.home.tabs.tasbeh

import android.animation.ObjectAnimator
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
        viewBinding = FragmentSebhaBinding.inflate(inflater,container,false)
        return viewBinding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.bodyOfSebha.setOnClickListener {
            spinTheSebha()
            initViews()
    }

}


    private fun spinTheSebha() {
        viewBinding.bodyOfSebha.rotation =viewBinding.bodyOfSebha.rotation+5
    }

    var count = 0
    var i = 0
    private fun initViews() {
        count++
        i++

        // Update the numbers TextView
        viewBinding.counterSebha.text = count.toString()

        // Update the texts TextView based on `i`
        when {
            i <= 33 -> viewBinding.tsabeh.text = "سبحان الله"
            i in 34..66 -> viewBinding.tsabeh.text = "الحمد الله"
            i in 67..99 -> viewBinding.tsabeh.text = "لا اله الا الله"
            i in 100..132 -> viewBinding.tsabeh.text = "الله أكبر"
        }

        // Reset `count` after every 33 clicks
        if (count % 33 == 0) {
            count = 0
        }

        // Reset `i` after 132 clicks
        if (i == 132) {
            i = 0
        }
    }
    }
