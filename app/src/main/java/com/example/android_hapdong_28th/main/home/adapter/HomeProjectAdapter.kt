package com.example.android_hapdong_28th.main.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_hapdong_28th.databinding.ItemHomeProjectBinding
import com.example.android_hapdong_28th.main.home.data.Editor

class HomeProjectAdapter(private val context: Context) :
    RecyclerView.Adapter<HomeProjectAdapter.HomeSmallViewHolder>() {

    var projectList = listOf<Editor>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeSmallViewHolder {
        val binding =
            ItemHomeProjectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeSmallViewHolder(binding)
    }

    override fun getItemCount(): Int = projectList.size

    override fun onBindViewHolder(holder: HomeSmallViewHolder, position: Int) {
        holder.onBind(projectList[position])
    }

    class HomeSmallViewHolder(
        private val binding: ItemHomeProjectBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(projectData: Editor) {
            Glide.with(binding.root).load(projectData.image).into(binding.image)
            binding.category.text = projectData.category
            binding.writer.text = projectData.writer
            binding.title.text = projectData.title
            binding.value.text = "${projectData.percent}% 달성"
//                if (projectData.kind == "editor") "${projectData.percent}% 달성" else "${projectData.value}"
        }
    }
}
