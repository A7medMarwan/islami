package com.example.islami.ui.home.tabs.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemChapterNameBinding

class ChapterNameRecyclerAdapter(val names: List<String>): RecyclerView.Adapter<ChapterNameRecyclerAdapter.ViewHolder>() {

    class ViewHolder(val viewBinding: ItemChapterNameBinding) : RecyclerView.ViewHolder(viewBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemChapterNameBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return names.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.name.text = names[position]
        if(onItemClickListener!= null){
            holder.viewBinding.root.setOnClickListener{
                onItemClickListener?.onClick(position,names[position])
            }
        }
    }

    var onItemClickListener: OnItemClickListener? = null
    fun interface OnItemClickListener{
        fun onClick(position: Int, name:String)
    }
}