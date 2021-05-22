package com.example.android_hapdong_28th.main.home.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_hapdong_28th.databinding.FragmentHomeProjectSecondPageBinding
import com.example.android_hapdong_28th.main.home.adapter.HomeProjectAdapter

class HomeProjectSecondPageFragment : Fragment() {
    private var _binding: FragmentHomeProjectSecondPageBinding? = null
    private val binding get() = _binding ?: error("View를 참조하기 위해 binding이 초기화되지 않았습니다.")

    private lateinit var homeProjectAdapter: HomeProjectAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeProjectSecondPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureProjectList()
    }

    private fun configureProjectList() {
        val projectList = HomeFragment.projectListForPager.subList(4, 8)
        homeProjectAdapter = HomeProjectAdapter(projectList)
        binding.rvSmall2.adapter = homeProjectAdapter
        homeProjectAdapter.notifyDataSetChanged()
    }
}