package com.example.android_hapdong_28th.main.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_hapdong_28th.databinding.ItemSearchBinding
import com.example.android_hapdong_28th.main.search.api.Item
import com.example.android_hapdong_28th.main.search.data.SearchItemInfo

class SearchListAdapter : RecyclerView.Adapter<SearchListAdapter.SearchItemViewHolder>() {

    val searchList = mutableListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchItemViewHolder {
        val binding = ItemSearchBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return SearchItemViewHolder(binding)
    }

    override fun getItemCount(): Int = searchList.size


    override fun onBindViewHolder(holder: SearchItemViewHolder, position: Int) {
        holder.onBind(searchList[position])
    }


    class SearchItemViewHolder(
        private val binding: ItemSearchBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(searchItem: Item) {
            binding.tvItemName.text = searchItem.title
            binding.tvItemTag.text = searchItem.category + " | " + searchItem.writer
            binding.tvItemDisc.text = searchItem.description
            binding.tvItemCost.text = searchItem.price
            binding.tvItemPercent.text = searchItem.percent.toString() + "%"
            binding.tvDay.text = searchItem.dDay.toString() + "일 남음"
            binding.progressBar.progress = searchItem.percent
            Glide.with(binding.root).load(searchItem.image).into(binding.ivItem)
        }
    }


}