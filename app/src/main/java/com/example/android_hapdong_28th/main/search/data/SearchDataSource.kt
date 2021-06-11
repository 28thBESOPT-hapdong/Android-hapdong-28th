package com.example.android_hapdong_28th.main.search.data

import com.example.android_hapdong_28th.main.search.api.Item

interface SearchDataSource {
    fun fetchSearchItems(): MutableList<Item>
}