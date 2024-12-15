package com.example.islami.ui.home.tabs.hadeeth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemChapterNameBinding
import com.example.islami.databinding.ItemHadeethBinding

class HadethRecyclerAdapter(private var names: List<Hadeth>?): RecyclerView.Adapter<HadethRecyclerAdapter.ViewHolder>() {

    class ViewHolder(val viewBinding: ItemHadeethBinding) : RecyclerView.ViewHolder(viewBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemHadeethBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return names?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.title.text = names!![position].title
        if(onItemClickListener!= null){
            holder.viewBinding.root.setOnClickListener{
                onItemClickListener?.onClick(position,names!![position])
            }
        }
    }

    fun bindDataList(items: List<Hadeth>){
        names = items
        notifyDataSetChanged()
    }

    var onItemClickListener: OnItemClickListener? = null
    fun interface OnItemClickListener{
        fun onClick(position: Int, name:Hadeth)
    }
}