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
        navigateHome()
    }

    private fun configureBottomNav() {
        binding.bottomNavi.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> navigateHome()
                R.id.menu_search -> navigateSearch("bottom")
            }
            true
        }
    }

    fun navigateHome() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, homeFragment)
        transaction.commit()
        binding.bottomNavi.menu.getItem(0).isChecked = true
    }

    fun navigateSearch(from: String) {
        val bundle = Bundle()
        val transaction = supportFragmentManager.beginTransaction()

        bundle.putString("from", from)
        searchFragment.arguments = bundle
        transaction.replace(R.id.fragment_container, searchFragment)
        transaction.commit()
        binding.bottomNavi.menu.getItem(1).isChecked = true
    }
}