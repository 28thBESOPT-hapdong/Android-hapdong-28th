package com.example.android_hapdong_28th.main.home.data

import com.example.android_hapdong_28th.main.home.api.HomeBannerRes

class LocalHomeDataSource : HomeDataSource {
    override fun fetchBannerItems(): MutableList<HomeBannerRes> {
        TODO()
    }

    override fun fetchProjectItems(): MutableList<HomeProjectData> {
        return MutableList<HomeProjectData>(8) { i ->
            HomeProjectData(
                "https://cdn.pixabay.com/photo/2020/06/06/06/44/new-york-5265414__480.jpg",
                "Category${i + 1}  |  ${i + 1}", "Upcoming Project\nTitle ${i + 1}", (i + 1) * 100
            )
        }
    }
}