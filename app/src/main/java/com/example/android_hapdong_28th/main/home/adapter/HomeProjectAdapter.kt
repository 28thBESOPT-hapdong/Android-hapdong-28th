package com.example.android_hapdong_28th.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_hapdong_28th.main.home.data.HomeProjectData
import com.bumptech.glide.Glide
import com.example.android_hapdong_28th.databinding.ItemHomeProjectBinding

class HomeProjectAdapter(private val projectList: MutableList<HomeProjectData>) :
    RecyclerView.Adapter<HomeProjectAdapter.HomeSmallViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeSmallViewHolder {
        val binding =
            ItemHomeProjectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeSmallViewHolder(binding)
    }

    override fun getItemCount(): Int = projectList.size

    override fun onBindViewHolder(holder: HomeSmallViewHolder, position: Int) {
        holder.onBind(projectList[position], projectList.size)
    }

    class HomeSmallViewHolder(
        private val binding: ItemHomeProjectBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(projectData: HomeProjectData, size: Int) {
            Glide.with(binding.root).load(projectData.image).into(binding.image)
            binding.category.text = projectData.category
            binding.title.text = projectData.title
            binding.value.text =
                if (size == 8) "${projectData.value}명이 알림신청 중" else "${projectData.value}% 달성"
        }
    }
}
