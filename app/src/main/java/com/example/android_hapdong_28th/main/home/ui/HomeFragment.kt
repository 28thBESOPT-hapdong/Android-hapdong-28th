package com.example.android_hapdong_28th.main.home.ui

import android.os.Bundle
import android.provider.Settings.Global.getString
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.widget.TextViewCompat
import com.example.android_hapdong_28th.R
import com.example.android_hapdong_28th.databinding.FragmentHomeBinding
import com.example.android_hapdong_28th.main.MainActivity
import com.example.android_hapdong_28th.main.home.adapter.HomeBannerAdapter
import com.example.android_hapdong_28th.main.home.adapter.HomeExhibitionAdapter
import com.example.android_hapdong_28th.main.home.adapter.HomeProjectAdapter
import com.example.android_hapdong_28th.main.home.adapter.HomeSmallPager2Adapter
import com.example.android_hapdong_28th.main.home.data.HomeBannerData
import com.example.android_hapdong_28th.main.home.data.HomeExhibitionData
import com.example.android_hapdong_28th.main.home.data.HomeProjectData

import com.google.android.material.tabs.TabLayout

class HomeFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding ?: error("View를 참조하기 위해 binding이 초기화되지 않았습니다.")

    private lateinit var homeBannerAdapter: HomeBannerAdapter
    private lateinit var homeUpcomingProjectAdapter: HomeProjectAdapter
    private lateinit var homePopularProjectAdapter: HomeProjectAdapter
    private lateinit var homeNewProjectAdapter: HomeProjectAdapter
    private lateinit var homeExhibitionAdapter: HomeExhibitionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureMainTab()
        configureMainBanner()
        configureMiddleTab()
        configureMiddlePager()
        configureProjectList()
        configureExhibitionList()
        configureNavigation()
    }

    private fun configureMainTab() {
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
        homeBannerAdapter = HomeBannerAdapter(bannerList)
        binding.banner.adapter = homeBannerAdapter
        homeBannerAdapter.notifyDataSetChanged()
    }

    private fun configureMiddleTab() {
        binding.middleTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val views = arrayListOf<View>()
                tab?.view?.findViewsWithText(views, tab.text, View.FIND_VIEWS_WITH_TEXT)
                views.forEach {
                    if (it is TextView) {
                        TextViewCompat.setTextAppearance(it, R.style.MiddleTabTheme_Selected)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val views = arrayListOf<View>()
                tab?.view?.findViewsWithText(views, tab.text, View.FIND_VIEWS_WITH_TEXT)
                views.forEach {
                    if (it is TextView) {
                        TextViewCompat.setTextAppearance(it, R.style.MiddleTabTheme)
                    }
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    private fun configureMiddlePager() {
        binding.vp2Small.adapter = HomeSmallPager2Adapter(this@HomeFragment)
    }

    private fun configureProjectList() {
        homeUpcomingProjectAdapter = HomeProjectAdapter(upcomingProjectList)
        binding.rvUpcomingProject.adapter = homeUpcomingProjectAdapter
        homeUpcomingProjectAdapter.notifyDataSetChanged()

        homePopularProjectAdapter = HomeProjectAdapter(popularProjectList)
        binding.rvPopularProject.adapter = homePopularProjectAdapter
        homePopularProjectAdapter.notifyDataSetChanged()

        homeNewProjectAdapter = HomeProjectAdapter(newProjectList)
        binding.rvNewProject.adapter = homeNewProjectAdapter
        homeNewProjectAdapter.notifyDataSetChanged()
    }

    private fun configureNavigation() {
        binding.upcomingProjectContainer.setOnClickListener { onClick(it) }
        binding.upcomingProjectBtn.setOnClickListener { onClick(it) }
        binding.popularProjectContainer.setOnClickListener { onClick(it) }
        binding.popularProjectBtn.setOnClickListener { onClick(it) }
        binding.newProjectContainer.setOnClickListener { onClick(it) }
        binding.newProjectBtn.setOnClickListener { onClick(it) }
    }

    private fun configureExhibitionList() {
        homeExhibitionAdapter = HomeExhibitionAdapter(exhibitionList)
        binding.rvExhibition.adapter = homeExhibitionAdapter
        homeExhibitionAdapter.notifyDataSetChanged()
    }

    override fun onClick(view: View?) {
        if (view != null) {
            when (view.id) {
                R.id.upcoming_project_container, R.id.upcoming_project_btn -> (activity as MainActivity).navigateSearch(
                    "upcoming"
                )
                R.id.popular_project_container, R.id.popular_project_btn -> (activity as MainActivity).navigateSearch(
                    "popular"
                )
                R.id.new_project_container, R.id.new_project_btn -> (activity as MainActivity).navigateSearch(
                    "new"
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        val bannerList = MutableList<HomeBannerData>(4) { i ->
            HomeBannerData(
                "https://cdn.pixabay.com/photo/2017/10/13/12/29/hands-2847508_1280.jpg",
                "Main Banner\nTitle ${i + 1}",
                "Content ${i + 1}"
            )
        }

        val upcomingProjectList = MutableList<HomeProjectData>(8) { i ->
            HomeProjectData(
                "https://cdn.pixabay.com/photo/2020/06/06/06/44/new-york-5265414__480.jpg",
                "Category${i + 1}  |  ${i + 1}", "Upcoming Project\nTitle ${i + 1}", (i + 1) * 100
            )
        }

        val exhibitionList = MutableList<HomeExhibitionData>(4) { i ->
            HomeExhibitionData(
                "https://cdn.pixabay.com/photo/2016/08/23/13/12/knitting-1614283_1280.jpg",
                "Exhibition Title ${i + 1}", (i + 1) * 100,
                arrayListOf("#tag1", "#tag2", "#tag3", "#tag4")
            )
        }

        val popularProjectList = MutableList<HomeProjectData>(8) { i ->
            HomeProjectData(
                "https://cdn.pixabay.com/photo/2021/01/21/15/54/books-5937716_1280.jpg",
                "Category${i + 1}  |  ${i + 1}", "Popular Project\nTitle ${i + 1}", (i + 1) * 100
            )
        }

        val newProjectList = MutableList<HomeProjectData>(8) { i ->
            HomeProjectData(
                "https://cdn.pixabay.com/photo/2021/01/29/14/41/wardrobe-5961193__480.jpg",
                "Category${i + 1}  |  ${i + 1}", "New Project\nTitle ${i + 1}", (i + 1) * 100
            )
        }
    }
}