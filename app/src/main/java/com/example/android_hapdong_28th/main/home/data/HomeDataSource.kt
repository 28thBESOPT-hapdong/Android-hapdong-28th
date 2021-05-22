package com.example.android_hapdong_28th.main.home.data

interface HomeDataSource {
    fun fetchBannerItems() : MutableList<HomeBannerData>
    fun fetchProjectItems() : MutableList<HomeProjectData>
}