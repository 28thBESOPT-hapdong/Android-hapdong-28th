package com.example.android_hapdong_28th.main.search.data

interface SearchDataSource {
    fun fetchSearchItems(): MutableList<SearchItemInfo>
}