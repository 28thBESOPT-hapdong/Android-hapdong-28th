package com.example.android_hapdong_28th.main.home.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android_hapdong_28th.main.home.ui.HomeProjectFirstPageFragment
import com.example.android_hapdong_28th.main.home.ui.HomeProjectSecondPageFragment
import com.example.android_hapdong_28th.main.home.ui.HomeProjectThirdPageFragment

class HomeProjectPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeProjectFirstPageFragment()
            1 -> HomeProjectSecondPageFragment()
            2 -> HomeProjectThirdPageFragment()
            else -> throw IllegalStateException("Unexpected position: $position")
        }
    }
}