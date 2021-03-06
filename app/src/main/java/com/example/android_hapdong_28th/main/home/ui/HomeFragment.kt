package com.example.android_hapdong_28th.main.home.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.widget.TextViewCompat
import androidx.viewpager.widget.ViewPager
import com.example.android_hapdong_28th.R
import com.example.android_hapdong_28th.databinding.FragmentHomeBinding
import com.example.android_hapdong_28th.main.MainActivity
import com.example.android_hapdong_28th.main.home.adapter.HomeBannerAdapter
import com.example.android_hapdong_28th.main.home.adapter.HomeExhibitionAdapter
import com.example.android_hapdong_28th.main.home.adapter.HomeProjectAdapter
import com.example.android_hapdong_28th.main.home.adapter.HomeProjectPagerAdapter
import com.example.android_hapdong_28th.main.home.api.HomeBannerRes
import com.example.android_hapdong_28th.main.home.api.HomeBannerWrapperRes
import com.example.android_hapdong_28th.main.home.api.RetrofitObject
import com.example.android_hapdong_28th.main.home.data.*
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.timer

class HomeFragment : Fragment(), View.OnClickListener {

    private lateinit var bannerViewPager: ViewPager
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
        bannerViewPager = _binding?.banner!!
        configureMainTab()
        configureMainBanner()
        configureMiddleTab()
        configureProjectPager()
        configureIndicator(binding)
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
        homeBannerAdapter = HomeBannerAdapter()
        RetrofitObject.homeBannerService.fetchHomeBanner().enqueue(object : retrofit2.Callback<HomeBannerWrapperRes> {
            override fun onResponse(
                call: Call<HomeBannerWrapperRes>,
                response: Response<HomeBannerWrapperRes>
            ) {
                if (response.isSuccessful) {
                    homeBannerAdapter.submitItem(response.body()?.data?.bannerData as MutableList<HomeBannerRes>)
                    Log.d("i'm successfully connect with server", response.body().toString())
                }
            }
            override fun onFailure(call: Call<HomeBannerWrapperRes>, t: Throwable) {
                Log.d("failed with connect server", t.message.toString())
            }
        })
        binding.banner.adapter = homeBannerAdapter

        //6초마다 자동슬라이드
        timer(period =  6000){
            activity?.runOnUiThread{
                if (bannerViewPager.currentItem < homeBannerAdapter.count-1){
                    bannerViewPager.currentItem++
                }else{
                    bannerViewPager.currentItem=0
                }
            }
        }
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

    private fun configureProjectPager() {
        binding.projectPager.apply {
            adapter = HomeProjectPagerAdapter(this@HomeFragment)
            isSaveEnabled = false
        }
    }

    private fun configureIndicator(binding: FragmentHomeBinding) {
        TabLayoutMediator(binding.indicator, binding.projectPager) { tab, position ->  }.attach()
    }

    private fun configureProjectList() {
        homeUpcomingProjectAdapter = HomeProjectAdapter(requireContext())
        binding.rvUpcomingProject.adapter = homeUpcomingProjectAdapter
        getServerUpcomingProjectData()

        homePopularProjectAdapter = HomeProjectAdapter(requireContext())
        binding.rvPopularProject.adapter = homePopularProjectAdapter
        getServerPopularProjectData()

        homeNewProjectAdapter = HomeProjectAdapter(requireContext())
        binding.rvNewProject.adapter = homeNewProjectAdapter
        getServerNewProjectData()
    }

    private fun configureExhibitionList() {
        homeExhibitionAdapter = HomeExhibitionAdapter(requireContext())
        binding.rvExhibition.adapter = homeExhibitionAdapter
        getServerExhibitionData()
    }

    private fun getServerUpcomingProjectData() {
        val call: Call<ResponseHomeProject> = RetrofitObject.TUMBLBUG_SERVICE.getHomeProject()
        call.enqueue(object : Callback<ResponseHomeProject> {
            override fun onResponse(
                call: Call<ResponseHomeProject>,
                response: Response<ResponseHomeProject>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        homeUpcomingProjectAdapter.projectList = it.data.editor
                        homeUpcomingProjectAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<ResponseHomeProject>, t: Throwable) {
                Log.d("tag", "t.localizedMessage!!")
            }

        })
    }

    private fun getServerPopularProjectData() {
        val call: Call<ResponseHomeProject> = RetrofitObject.TUMBLBUG_SERVICE.getHomeProject()
        call.enqueue(object : Callback<ResponseHomeProject> {
            override fun onResponse(
                call: Call<ResponseHomeProject>,
                response: Response<ResponseHomeProject>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        homePopularProjectAdapter.projectList = it.data.editor
                        homePopularProjectAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<ResponseHomeProject>, t: Throwable) {
                Log.d("tag", "t.localizedMessage!!")
            }

        })
    }

    private fun getServerNewProjectData() {
        val call: Call<ResponseHomeProject> = RetrofitObject.TUMBLBUG_SERVICE.getHomeProject()
        call.enqueue(object : Callback<ResponseHomeProject> {
            override fun onResponse(
                call: Call<ResponseHomeProject>,
                response: Response<ResponseHomeProject>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        homeNewProjectAdapter.projectList = it.data.editor
                        homeNewProjectAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<ResponseHomeProject>, t: Throwable) {
                Log.d("tag", "t.localizedMessage!!")
            }

        })
    }

    private fun getServerExhibitionData() {
        val call: Call<ResponseHomeExhibition> = RetrofitObject.TUMBLBUG_SERVICE.getHomeExhibition()
        call.enqueue(object : Callback<ResponseHomeExhibition> {
            override fun onResponse(
                call: Call<ResponseHomeExhibition>,
                response: Response<ResponseHomeExhibition>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        homeExhibitionAdapter.exhibitionList = it.data.exhibition
                        homeExhibitionAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<ResponseHomeExhibition>, t: Throwable) {
                Log.d("tag", "t.localizedMessage!!")
            }

        })
    }

    private fun configureNavigation() {
        binding.upcomingProjectContainer.setOnClickListener { onClick(it) }
        binding.upcomingProjectBtn.setOnClickListener { onClick(it) }
        binding.popularProjectContainer.setOnClickListener { onClick(it) }
        binding.popularProjectBtn.setOnClickListener { onClick(it) }
        binding.newProjectContainer.setOnClickListener { onClick(it) }
        binding.newProjectBtn.setOnClickListener { onClick(it) }
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
}