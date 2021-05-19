package com.example.android_hapdong_28th.main.home.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.widget.TextViewCompat
import com.example.android_hapdong_28th.R
import com.example.android_hapdong_28th.databinding.FragmentHomeBinding
import com.example.android_hapdong_28th.main.MainActivity
import com.example.android_hapdong_28th.main.home.adapter.BannerPagerAdapter
import com.example.android_hapdong_28th.main.home.adapter.HomeSmallListAdapter
import com.example.android_hapdong_28th.main.home.data.BannerData
import com.example.android_hapdong_28th.main.home.data.HomeSmallData
import com.google.android.material.tabs.TabLayout

class HomeFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding ?: error("View를 참조하기 위해 binding이 초기화되지 않았습니다.")
    private lateinit var bannerPagerAdapter: BannerPagerAdapter
    private lateinit var homeSmallListAdapter1: HomeSmallListAdapter
    private lateinit var homeSmallListAdapter2: HomeSmallListAdapter
    private lateinit var homeSmallListAdapter3: HomeSmallListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureTab()
        configureMainBanner()
        configureNavigation()

        homeSmallListAdapter1 = HomeSmallListAdapter()
        _binding?.rv1?.adapter = homeSmallListAdapter1
        saveDataHomeSmall(homeSmallListAdapter1)

        homeSmallListAdapter2 = HomeSmallListAdapter()
        _binding?.rv2?.adapter = homeSmallListAdapter2
        saveDataHomeSmall(homeSmallListAdapter2)
        homeSmallListAdapter3 = HomeSmallListAdapter()
        _binding?.rv3?.adapter = homeSmallListAdapter3
        saveDataHomeSmall(homeSmallListAdapter3)


    }

    private fun configureTab() {
        binding.mainTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val views = arrayListOf<View>()
                tab?.view?.findViewsWithText(views, tab.text, View.FIND_VIEWS_WITH_TEXT)
                views.forEach {
                    if (it is TextView) {
                        TextViewCompat.setTextAppearance(it, R.style.MainTabTheme_Selected)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val views = arrayListOf<View>()
                tab?.view?.findViewsWithText(views, tab.text, View.FIND_VIEWS_WITH_TEXT)
                views.forEach {
                    if (it is TextView) {
                        TextViewCompat.setTextAppearance(it, R.style.MainTabTheme)
                    }
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    private fun configureMainBanner() {
        bannerPagerAdapter = BannerPagerAdapter(bannerList)
        binding.banner.adapter = bannerPagerAdapter
    }

    private fun configureNavigation() {
        binding.homeTitle1.setOnClickListener { onClick(it) }
        binding.homeBtn1.setOnClickListener { onClick(it) }
        binding.homeTitle2.setOnClickListener { onClick(it) }
        binding.homeBtn2.setOnClickListener { onClick(it) }
        binding.homeTitle3.setOnClickListener { onClick(it) }
        binding.homeBtn3.setOnClickListener { onClick(it) }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.home_title1, R.id.home_btn1 -> (activity as MainActivity).navigateSearch("title1")
                R.id.home_title2, R.id.home_btn2 -> (activity as MainActivity).navigateSearch("title2")
                R.id.home_title3, R.id.home_btn3 -> (activity as MainActivity).navigateSearch("title3")
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun saveDataHomeSmall(Adapter: HomeSmallListAdapter){
        Adapter.homeSmallList.addAll (
            listOf<HomeSmallData>(
                HomeSmallData(
                    image = "https://cdn.pixabay.com/photo/2017/10/13/12/29/hands-2847508_1280.jpg",
                    title = "title1",
                    goal = "goal1",
                    category = "category1"
                ),
                HomeSmallData(
                    image = "https://cdn.pixabay.com/photo/2017/10/13/12/29/hands-2847508_1280.jpg",
                    title = "title2",
                    goal = "goal2",
                    category = "category2"
                ),
                HomeSmallData(
                    image = "https://cdn.pixabay.com/photo/2017/10/13/12/29/hands-2847508_1280.jpg",
                    title = "title3",
                    goal = "goal3",
                    category = "category3"
                ),
                HomeSmallData(
                    image = "https://cdn.pixabay.com/photo/2017/10/13/12/29/hands-2847508_1280.jpg",
                    title = "title4",
                    goal = "goal4",
                    category = "category4"
                ),
                HomeSmallData(
                    image = "https://cdn.pixabay.com/photo/2017/10/13/12/29/hands-2847508_1280.jpg",
                    title = "title5",
                    goal = "goal5",
                    category = "category5"
                ),
                HomeSmallData(
                    image = "https://cdn.pixabay.com/photo/2017/10/13/12/29/hands-2847508_1280.jpg",
                    title = "title6",
                    goal = "goal6",
                    category = "category6"
                ),
                HomeSmallData(
                    image = "https://cdn.pixabay.com/photo/2017/10/13/12/29/hands-2847508_1280.jpg",
                    title = "title7",
                    goal = "goal7",
                    category = "category7"
                ),
                HomeSmallData(
                    image = "https://cdn.pixabay.com/photo/2017/10/13/12/29/hands-2847508_1280.jpg",
                    title = "title18",
                    goal = "goal8",
                    category = "category8"
                )
            )
        )
    }

    companion object {
        val bannerList = mutableListOf(
            BannerData(
                "https://cdn.pixabay.com/photo/2017/10/13/12/29/hands-2847508_1280.jpg",
                "title1",
                "content1"
            ),
            BannerData(
                "https://cdn.pixabay.com/photo/2017/10/10/21/47/laptop-2838921_1280.jpg",
                "title2",
                "content2"
            ),
            BannerData(
                "https://cdn.pixabay.com/photo/2017/10/13/12/29/hands-2847508_1280.jpg",
                "title3",
                "content3"
            ),
            BannerData(
                "https://cdn.pixabay.com/photo/2017/10/10/21/47/laptop-2838921_1280.jpg",
                "title3",
                "content4"
            ),
        )
    }
}