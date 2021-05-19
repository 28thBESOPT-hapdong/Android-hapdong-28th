package com.example.android_hapdong_28th.main.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.android_hapdong_28th.databinding.ItemHomeBannerBinding
import com.example.android_hapdong_28th.main.home.data.HomeBannerData

class HomeBannerAdapter(private val bannerList: MutableList<HomeBannerData>) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding =
            ItemHomeBannerBinding.inflate(LayoutInflater.from(container.context), container, false)
        Glide.with(binding.root).load(bannerList[position].image).into(binding.bannerImage)
        binding.bannerTitle.text = bannerList[position].title
        binding.bannerContent.text = bannerList[position].content
        binding.bannerIndex.text = "${position + 1} "
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
}