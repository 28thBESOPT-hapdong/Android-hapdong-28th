package com.example.android_hapdong_28th.main.home.data

class LocalHomeDataSource : HomeDataSource {
    override fun fetchBannerItems(): MutableList<HomeBannerData> {
        return MutableList<HomeBannerData>(4) { i ->
            HomeBannerData(
                "https://cdn.pixabay.com/photo/2017/10/13/12/29/hands-2847508_1280.jpg",
                "Main Banner\nTitle ${i + 1}",
                "Content ${i + 1}"
            )
        }
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