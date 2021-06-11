package com.example.android_hapdong_28th.main.home.api

import com.example.android_hapdong_28th.main.home.data.ResponseHomeExhibition
import com.example.android_hapdong_28th.main.home.data.ResponseHomeProject
import retrofit2.http.GET
import retrofit2.Call

interface TumblbugService {

    // 에디터픽 조회
    @GET("api/project/editor")
    fun getHomeProject(): Call<ResponseHomeProject>

    // 공개예정 프로젝트 조회
    @GET("api/project/open")
    fun getHomeUpcomingProject(): Call<ResponseHomeProject>

    // 인기 추천 프로젝트 조회
    @GET("api/project/popular")
    fun getHomePopularProject(): Call<ResponseHomeProject>

    // 신규 추천 프로젝트 조회
    @GET("api/project/new")
    fun getHomeNewProject(): Call<ResponseHomeProject>

    // 진행중인 기획전 조회
    @GET("api/exhibition")
    fun getHomeExhibition(): Call<ResponseHomeExhibition>
}