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
import com.example.android_hapdong_28th.main.search.data.LocalSearchDataSource
import com.example.android_hapdong_28th.main.search.data.SearchDataSource
import com.example.android_hapdong_28th.main.search.data.SearchItemInfo

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding ?: error("View를 참조하기 위해 binding이 초기화되지 않았습니다.")

    private lateinit var searchListAdapter: SearchListAdapter
    private var searchDataSource: SearchDataSource = LocalSearchDataSource()

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

        searchListAdapter.searchList.addAll(searchDataSource.fetchSearchItems())

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