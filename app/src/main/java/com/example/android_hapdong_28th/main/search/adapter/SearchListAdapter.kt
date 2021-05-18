package com.example.android_hapdong_28th.main.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_hapdong_28th.databinding.ItemSearchBinding
import com.example.android_hapdong_28th.main.search.data.SearchItemInfo

class SearchListAdapter : RecyclerView.Adapter<SearchListAdapter.SearchItemViewHolder>() {

    val searchList = mutableListOf<SearchItemInfo>()

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
        fun onBind(searchItemInfo: SearchItemInfo) {
            binding.tvItemName.text = searchItemInfo.itemName
            binding.tvItemTag.text = searchItemInfo.itemTag
            binding.tvItemDisc.text = searchItemInfo.itemDisc
            binding.tvItemCost.text = searchItemInfo.itemCost
            binding.tvItemPercent.text = searchItemInfo.itemPercent.toString() + "%"
            binding.tvDay.text = searchItemInfo.itemDay.toString() + "일 남음"
            binding.progressBar.progress = searchItemInfo.itemPercent
            Glide.with(binding.root).load(searchItemInfo.itemImage).into(binding.ivItem)
        }
    }


}