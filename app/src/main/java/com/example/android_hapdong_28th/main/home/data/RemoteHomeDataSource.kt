package com.example.android_hapdong_28th.main.home.data

import com.example.android_hapdong_28th.main.home.api.RetrofitObject

class RemoteHomeDataSource : HomeDataSource {
    override fun fetchBannerItems(): MutableList<HomeBannerData> {
        val response = RetrofitObject.TUMBLBUG_SERVICE
        TODO()
    }

    override fun fetchProjectItems(): MutableList<HomeProjectData> {
        TODO()
    }
}