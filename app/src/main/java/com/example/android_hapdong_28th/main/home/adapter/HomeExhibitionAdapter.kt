package com.example.android_hapdong_28th.main.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_hapdong_28th.databinding.ItemHomeExhibitionBinding
import com.example.android_hapdong_28th.main.home.data.Exhibition
import com.example.android_hapdong_28th.main.home.data.HomeExhibitionData

class HomeExhibitionAdapter(private val context: Context) :
    RecyclerView.Adapter<HomeExhibitionAdapter.HomeExhibitionViewHolder>() {

    var exhibitionList = listOf<Exhibition>()

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
        fun onBind(exhibitionData: Exhibition) {
            Glide.with(binding.root).load(exhibitionData.image).into(binding.image)
            binding.title.text = exhibitionData.title
            binding.projectCount.text = exhibitionData.num.toString()
            val tag = exhibitionData.tags[0].split(",")
            binding.tag1.text = "#${tag[0]}"
            binding.tag2.text = "#${tag[1]}"
            binding.tag3.text = "#${tag[2]}"
            binding.tag4.text = "#${tag[3]}"
        }
    }
}