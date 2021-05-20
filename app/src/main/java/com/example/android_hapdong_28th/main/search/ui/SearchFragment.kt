package com.example.android_hapdong_28th.main.search.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_hapdong_28th.R
import com.example.android_hapdong_28th.databinding.FragmentSearchBinding
import com.example.android_hapdong_28th.main.MainActivity
import com.example.android_hapdong_28th.main.search.adapter.SearchListAdapter
import com.example.android_hapdong_28th.main.search.data.SearchItemInfo

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding ?: error("View를 참조하기 위해 binding이 초기화되지 않았습니다.")

    private lateinit var searchListAdapter: SearchListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val result = arguments?.getString("from").toString()
        setButtonText(result)

        navigateHomeFromSearch()

        searchListAdapter = SearchListAdapter()

        binding.rvSearchList.adapter = searchListAdapter

        searchListAdapter.searchList.addAll(
            listOf<SearchItemInfo>(
                SearchItemInfo(
                    itemImage = "https://cdn.pixabay.com/photo/2020/12/06/16/16/cosmos-5809271__340.png",
                    itemName = "누구나 쉽게 타로를 볼 수 있는 '별 타로'",
                    itemTag = "그래픽 디자인 | 별",
                    itemDisc = "타로를 배우지 않아도 누구나 쉽고 정확하게 점을 볼 수 있는 타로 카드 '별 타로'입니다.",
                    itemCost = "968,000원",
                    itemPercent = 72,
                    itemDay = 12
                ),
                SearchItemInfo(
                    itemImage = "https://cdn.pixabay.com/photo/2020/12/06/16/16/cosmos-5809271__340.png",
                    itemName = "호감가는 대화의 비밀, 한 알로 가볍게 챙기는 숨결케어",
                    itemTag = "잡화 | Stasty",
                    itemDisc = "[식약처인증/구취감소 98%] 씹을수록 상쾌한 데일리 덴탈케어, 환경까지 챙긴 순수 성분!",
                    itemCost = "968,000원",
                    itemPercent = 72,
                    itemDay = 12
                ),
                SearchItemInfo(
                    itemImage = "https://cdn.pixabay.com/photo/2020/12/06/16/16/cosmos-5809271__340.png",
                    itemName = "누구나 쉽게 타로를 볼 수 있는 '별 타로'",
                    itemTag = "그래픽 디자인 | 별",
                    itemDisc = "타로를 배우지 않아도 누구나 쉽고 정확하게 점을 볼 수 있는 타로 카드 '별 타로'입니다.",
                    itemCost = "968,000원",
                    itemPercent = 72,
                    itemDay = 12
                )
            )
        )
        searchListAdapter.notifyDataSetChanged()

    }

    private fun setButtonText(from: String) {
        when (from) {
            "bottom" -> {
                binding.btnProject.visibility = View.GONE
                binding.ivClosePro.visibility = View.GONE
            }
            "upcoming" -> binding.btnProject.text = getString(R.string.upcoming_project_title)
            "popular" -> binding.btnProject.text = getString(R.string.popular_project_title)
            "new" -> binding.btnProject.text = getString(R.string.new_project_title)
        }
    }

    private fun navigateHomeFromSearch() {
        binding.ivArrow.setOnClickListener {
            (activity as MainActivity).navigateHome()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}