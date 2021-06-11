package com.example.android_hapdong_28th.main.home.data

data class ResponseHomeProject(
    val `data`: Data,
    val status: Int
) {
    data class Data(
        val editor: List<Editor>
    )
}
data class Editor(
    val _id: String,
    val category: String,
    val id: Int,
    val image: String,
    val kind: String,
    val percent: Int,
    val title: String,
    val writer: String
)
