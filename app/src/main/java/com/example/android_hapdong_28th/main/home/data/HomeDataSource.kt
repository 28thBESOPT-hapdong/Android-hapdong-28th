package com.example.android_hapdong_28th.main.home.data

import com.example.android_hapdong_28th.main.home.api.HomeBannerRes

interface HomeDataSource {
    fun fetchBannerItems() : MutableList<HomeBannerRes>
    fun fetchProjectItems() : MutableList<HomeProjectData>
}