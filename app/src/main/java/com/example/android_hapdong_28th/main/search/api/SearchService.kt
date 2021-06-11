package com.example.android_hapdong_28th.main.search.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface SearchService {
    @GET("/api/detail")
    fun getSearch() : Call<ResSearch>
}