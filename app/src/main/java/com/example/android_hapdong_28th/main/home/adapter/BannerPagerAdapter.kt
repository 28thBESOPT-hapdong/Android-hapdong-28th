package com.example.android_hapdong_28th.main.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.android_hapdong_28th.databinding.ItemBannerBinding
import com.example.android_hapdong_28th.main.home.data.BannerData

class BannerPagerAdapter(private val list: MutableList<BannerData>) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding =
            ItemBannerBinding.inflate(LayoutInflater.from(container.context), container, false)
        Glide.with(binding.root).load(list[position].image).into(binding.bannerImage)
        binding.bannerTitle.text = list[position].title
        binding.bannerContent.text = list[position].content
        binding.bannerIndex.text = "${position + 1} "
        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View?)
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }
}