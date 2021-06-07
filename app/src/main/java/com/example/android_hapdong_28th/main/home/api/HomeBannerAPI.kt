package com.example.android_hapdong_28th.main.home.api

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET

// Data class 만들어주기
// 이름을 제대로 못지었어요~
data class HomeBannerWrapperRes(
    @SerializedName("status")
    val status : Int,
    @SerializedName("data")
    val data : HomeBannerData
)

data class HomeBannerData(
    @SerializedName("banner")
    val bannerData : List<HomeBannerRes>
)

data class HomeBannerRes(
    @SerializedName("id")
    val id : String,
    @SerializedName("image" )
    val image : String,
    @SerializedName("title")
    val title : String,
    @SerializedName("description")
    val description : String
)

// service 객체
interface HomeBannerService{
    @GET("api/banner")
    fun fetchHomeBanner() : Call<HomeBannerWrapperRes>
}