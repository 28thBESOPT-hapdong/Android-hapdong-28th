package com.example.android_hapdong_28th.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_hapdong_28th.databinding.ItemHomeExhibitionBinding
import com.example.android_hapdong_28th.main.home.data.HomeExhibitionData

class HomeExhibitionAdapter(private val exhibitionList: MutableList<HomeExhibitionData>) :
    RecyclerView.Adapter<HomeExhibitionAdapter.HomeExhibitionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeExhibitionViewHolder {
        val binding =
            ItemHomeExhibitionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeExhibitionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeExhibitionViewHolder, position: Int) {
        holder.onBind(exhibitionList[position])
    }

    override fun getItemCount(): Int = exhibitionList.size

    class HomeExhibitionViewHolder(
        private val binding: ItemHomeExhibitionBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(exhibitionData: HomeExhibitionData) {
            Glide.with(binding.root).load(exhibitionData.image).into(binding.image)
            binding.title.text = exhibitionData.title
            binding.projectCount.text = exhibitionData.count.toString()
            binding.tag1.text = exhibitionData.tag[0]
            binding.tag2.text = exhibitionData.tag[1]
            binding.tag3.text = exhibitionData.tag[2]
            binding.tag4.text = exhibitionData.tag[3]
        }
    }
}