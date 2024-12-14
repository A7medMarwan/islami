package com.example.islami.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.databinding.ActivityHomeBinding
import com.example.islami.databinding.FragmentHadeethBinding
import com.example.islami.ui.home.tabs.hadeeth.HadeethFragment
import com.example.islami.ui.home.tabs.quran.QuranFragment
import com.example.islami.ui.home.tabs.radio.RadioFragment
import com.example.islami.ui.home.tabs.tasbeh.SebhaFragment

class HomeActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.content.bottomNav.setOnItemSelectedListener { it->
            if (it.itemId == R.id.quran){
                pushFragment(QuranFragment())
            }else if (it.itemId == R.id.hadeeth){
                pushFragment(HadeethFragment())
            }else if (it.itemId == R.id.sebha){
                pushFragment(SebhaFragment())
            }else if (it.itemId == R.id.radio){
                pushFragment(RadioFragment())
            }
            return@setOnItemSelectedListener true
        }
        viewBinding.content.bottomNav.selectedItemId = R.id.quran
    }

    private fun pushFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()

    }
}