package com.example.android_hapdong_28th.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_hapdong_28th.main.home.data.HomeSmallData
import com.bumptech.glide.Glide
import com.example.android_hapdong_28th.databinding.ItemHomeSmallBinding

class HomeSmallListAdapter: RecyclerView.Adapter<HomeSmallListAdapter.HomeSmallViewHolder>(){
    val homeSmallList = mutableListOf<HomeSmallData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeSmallViewHolder {
        val binding = ItemHomeSmallBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeSmallViewHolder(binding)
    }

    override fun getItemCount(): Int = homeSmallList.size

    override fun onBindViewHolder(holder: HomeSmallViewHolder, position: Int) {
        holder.onBind(homeSmallList[position])
    }

    class HomeSmallViewHolder(
        private val binding: ItemHomeSmallBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(SmallDataInfo: HomeSmallData) {
            Glide.with(binding.root).load(SmallDataInfo.image).into(binding.smallImage)
            binding.smallTitle.text = SmallDataInfo.title
            binding.smallGoal.text = SmallDataInfo.goal
            binding.smallCategory.text = SmallDataInfo.category
        }
    }
}
