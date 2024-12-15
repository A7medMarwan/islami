package com.example.islami.ui.home.tabs.hadeeth

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.islami.R
import com.example.islami.databinding.ActivityHadethDetailsBinding
import com.example.islami.ui.home.Constants

class HadethDetails : AppCompatActivity() {
    lateinit var viewBinding: ActivityHadethDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
        initParams()
        viewBinding.title.text = hadethTitle
        viewBinding.content.hadethContent.text = hadethContent


    }

    private fun initViews() {
        // to show back icon
        setSupportActionBar(viewBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = ""
    }

    // to active back icon
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }


    lateinit var hadethTitle: String
    lateinit var hadethContent: String
    private fun initParams() {
        hadethTitle = intent.getStringExtra(Constants.EXTRA_HADETH_TITLE)?:""
        hadethContent = intent.getStringExtra(Constants.EXTRA_HADETH_CONTENT)?:""
    }
}