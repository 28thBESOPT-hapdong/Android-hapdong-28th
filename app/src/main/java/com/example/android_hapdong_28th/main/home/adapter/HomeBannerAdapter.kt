package com.example.android_hapdong_28th.main.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.android_hapdong_28th.databinding.ItemHomeBannerBinding
import com.example.android_hapdong_28th.main.home.api.HomeBannerRes
import com.example.android_hapdong_28th.main.home.data.HomeBannerData

class HomeBannerAdapter() : PagerAdapter() {
    private val bannerList = mutableListOf<HomeBannerRes>()
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding =
            ItemHomeBannerBinding.inflate(LayoutInflater.from(container.context), container, false)
        Glide.with(binding.root).load(bannerList[position].image).into(binding.image)
        binding.title.text = bannerList[position].title
        binding.content.text = bannerList[position].description
        binding.index.text = "${position + 1} "
        binding.size.text = "/ ${bannerList.size}"
        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View?)
    }

    override fun getCount(): Int = bannerList.size

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    fun submitItem(items : MutableList<HomeBannerRes>){
        bannerList.clear()
        bannerList.addAll(items)
        notifyDataSetChanged()
    }
}