package com.example.islami.ui.home.tabs.hadeeth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami.R
import com.example.islami.databinding.FragmentHadeethBinding
import com.example.islami.databinding.FragmentQuranBinding
import com.example.islami.databinding.FragmentRadioBinding
import com.example.islami.ui.home.Constants


class HadeethFragment : Fragment() {
    lateinit var viewBinding: FragmentHadeethBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
            viewBinding = FragmentHadeethBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }


    override fun onStart() {
        super.onStart()
        loadFile()
        bindHadethList()
    }

    private fun bindHadethList() {
        adapter.bindDataList(hadethList)
    }

    lateinit var adapter: HadethRecyclerAdapter
    private fun initRecyclerView() {
        adapter = HadethRecyclerAdapter(null)
        viewBinding.recyclerview.adapter = adapter
        adapter.onItemClickListener =
            HadethRecyclerAdapter.OnItemClickListener { position, name ->
                val intent = Intent(requireContext(), HadethDetails::class.java)
                intent.putExtra(Constants.EXTRA_HADETH_TITLE, name.title)
                intent.putExtra(Constants.EXTRA_HADETH_CONTENT, name.content)
                startActivity(intent)

            }
    }

    val hadethList = mutableListOf<Hadeth>()
    private fun loadFile() {
        val fileContent = requireActivity().assets.open("ahadeth .txt").bufferedReader().use { it.readText() }
        val singleHadethList =  fileContent.trim().split("#")
        singleHadethList.forEach { element->
            val lines = element.trim().split("\n")
            val title = lines[0]
            val content = lines.drop(1).joinToString("\n")
            val hadeth = Hadeth(title, content)
            hadethList.add(hadeth)
        }

    }
}