package com.example.islami.ui.home.tabs.quran

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewbinding.ViewBinding
import com.example.islami.R
import com.example.islami.databinding.ActivityQuranContentBinding
import com.example.islami.ui.home.Constants

class QuranContent : AppCompatActivity() {
    lateinit var viewBinding: ActivityQuranContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityQuranContentBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initParams()
        initViews()
        loadChapterFile()

    }

    private fun initViews() {
        // to show back icon
        setSupportActionBar(viewBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = ""


        viewBinding.suraName.text = chapterName
    }

    // to active back icon
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    lateinit var adapter: VersesAdapter
    private fun bindVerses(verses: List<String>) {
        adapter = VersesAdapter(verses)
        viewBinding.content.contentRecyclerview.adapter = adapter
    }

    private fun loadChapterFile(){
        val fileContent =
            assets.open("$chapterIndex.txt").bufferedReader().use { it.readText() }
        val lines = fileContent.trim().split("\n")
        bindVerses(lines)
    }

    lateinit var chapterName: String
    var chapterIndex: Int = 0
    private fun initParams() {
        chapterName = "سورة " + (intent.getStringExtra(Constants.EXTRA_CHAPTER_NAME)?:"" )
        chapterIndex = intent.getIntExtra(Constants.EXTRA_CHAPTER_INDEX, 0)
0    }
}