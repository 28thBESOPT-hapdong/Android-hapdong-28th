package com.example.android_hapdong_28th.main.home.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_hapdong_28th.databinding.FragmentHomeSmallFirstBinding
import com.example.android_hapdong_28th.main.home.adapter.HomeProjectAdapter
import com.example.android_hapdong_28th.main.home.data.HomeBannerData
import com.example.android_hapdong_28th.main.home.data.HomeProjectData

class HomeSmallFirstFragment : Fragment() {
    private var _binding: FragmentHomeSmallFirstBinding? = null
    private val binding get() = _binding ?: error("View를 참조하기 위해 binding이 초기화되지 않았습니다.")

    private lateinit var homeProjectAdapter: HomeProjectAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeSmallFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureProjectList()
    }

    private fun configureProjectList() {
        homeProjectAdapter = HomeProjectAdapter(projectList)
        binding.rvSmall1.adapter = homeProjectAdapter
        homeProjectAdapter.notifyDataSetChanged()
    }

    companion object {
        val projectList = MutableList<HomeProjectData>(4) { i ->
            HomeProjectData(
                "https://cdn.pixabay.com/photo/2020/06/06/06/44/new-york-5265414__480.jpg",
                "Category${i + 1}  |  ${i + 1}", "Upcoming Project\nTitle ${i + 1}", (i + 1) * 100
            )
        }
    }
}