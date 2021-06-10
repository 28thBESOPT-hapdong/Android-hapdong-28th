package com.example.android_hapdong_28th.main.home.data

import android.util.Log
import com.example.android_hapdong_28th.main.home.api.HomeBannerRes
import com.example.android_hapdong_28th.main.home.api.HomeBannerWrapperRes
import com.example.android_hapdong_28th.main.home.api.RetrofitObject
import kotlinx.coroutines.coroutineScope
import retrofit2.Call
import retrofit2.Response
class RemoteHomeDataSource : HomeDataSource {
    override fun fetchBannerItems(): MutableList<HomeBannerRes> {
        val service = RetrofitObject.homeBannerService
        val data = mutableListOf<HomeBannerRes>()
        // 한유림 생각
        // data이 생성이 됐지
        // enqueue -> 백그라운드 쓰레드로 갔지
        // 하지만 ui 쓰레드는 진행되겠지
        // data가 그냥 빈채로 나오는거야

        // 백그라운드 쓰레드로 왜 돌렸어?? -> ui쓰레드가 막히면 안되기 떄문에 이를 백그라운드 쓰레드로 돌렸어
        // 만약에 이걸 동기화로 lock을 걸면
        // 안하니만 못하게돼
        service.fetchHomeBanner().enqueue(object : retrofit2.Callback<HomeBannerWrapperRes> {
            override fun onResponse(
                call: Call<HomeBannerWrapperRes>,
                response: Response<HomeBannerWrapperRes>
            ) {
                if (response.isSuccessful) {
                    data.addAll(response.body()!!.data.bannerData)
                    Log.d("i'm successfully connect with server", response.body().toString())
                }
            }
            override fun onFailure(call: Call<HomeBannerWrapperRes>, t: Throwable) {
                Log.d("failed with connect server", t.message.toString())
            }
        })
        return data
    }

    override fun fetchProjectItems(): MutableList<HomeProjectData> {
        return mutableListOf(HomeProjectData("test", "category", "title", 1))
    }
}