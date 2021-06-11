package com.example.android_hapdong_28th.main.home.api

import com.example.android_hapdong_28th.main.home.data.ResponseHomeProject
import retrofit2.http.GET
import retrofit2.Call

interface TumblbugService {

    // HomeProject 조회
    @GET("api/project/editor")
    fun getHomeProject(): Call<ResponseHomeProject>
}