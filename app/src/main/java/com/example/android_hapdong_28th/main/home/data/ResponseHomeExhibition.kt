package com.example.android_hapdong_28th.main.home.data

data class ResponseHomeExhibition(
    val `data`: Data,
    val status: Int
) {
    data class Data(
        val exhibition: List<Exhibition>
    )
}
data class Exhibition(
    val _id: String,
    val id: Int,
    val image: String,
    val num: Int,
    val tags: List<String>,
    val title: String
)