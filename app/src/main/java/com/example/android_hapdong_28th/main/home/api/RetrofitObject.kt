package com.example.android_hapdong_28th.main.home.api

import com.example.android_hapdong_28th.main.search.api.SearchService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    private const val BASE_URL = "http://3.35.49.237:5000/"

    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    private fun provideClient() = OkHttpClient.Builder()
        .addInterceptor(provideLoggingInterceptor())
        .build()

    private fun provideRetrofitObject(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).client(provideClient())
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    val TUMBLBUG_SERVICE = provideRetrofitObject().create(TumblbugService::class.java)

    val homeBannerService = provideRetrofitObject().create(HomeBannerService::class.java)
    val searchService = provideRetrofitObject().create(SearchService::class.java)
}