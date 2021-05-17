package com.example.android_hapdong_28th.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_hapdong_28th.R
import com.example.android_hapdong_28th.databinding.ActivityMainBinding
import com.example.android_hapdong_28th.main.home.ui.HomeFragment
import com.example.android_hapdong_28th.main.search.ui.SearchFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val homeFragment by lazy { HomeFragment() }
    private val searchFragment by lazy { SearchFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureBottomNav()
    }

    private fun configureBottomNav() {
        binding.bottomNavi.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.menu_home -> navigateHome()
                R.id.menu_search -> navigateSearch()
            }
        }
    }

    private fun navigateHome() {}
    private fun navigateSearch() {}
}