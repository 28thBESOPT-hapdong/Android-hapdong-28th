package com.example.android_hapdong_28th.main.home.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android_hapdong_28th.main.home.ui.HomeSmallFirstFragment
import com.example.android_hapdong_28th.main.home.ui.HomeSmallSecondFragment
import com.example.android_hapdong_28th.main.home.ui.HomeSmallThirdFragment

class HomeSmallPager2Adapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeSmallFirstFragment()
            1 -> HomeSmallSecondFragment()
            2 -> HomeSmallThirdFragment()
            else -> throw IllegalStateException("Unexpected position: $position")
        }
    }
}