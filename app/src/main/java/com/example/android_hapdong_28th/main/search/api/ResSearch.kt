package com.example.android_hapdong_28th.main.search.api

import com.google.gson.annotations.SerializedName

data class ResSearch(
    val status : Int,
    val data : Detail
)

data class Detail(
    @SerializedName("detail")
    val item : MutableList<Item>
)

data class Item(
    val _id : String,
    val id : Int,
    val image : String,
    val category : String,
    val writer : String,
    val title : String,
    val description : String,
    val price : String,
    val percent : Int,
    val dDay : Int
)
