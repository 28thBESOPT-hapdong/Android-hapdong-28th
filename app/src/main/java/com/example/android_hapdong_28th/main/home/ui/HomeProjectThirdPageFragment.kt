package com.example.android_hapdong_28th.main.home.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_hapdong_28th.databinding.FragmentHomeProjectThirdPageBinding
import com.example.android_hapdong_28th.main.home.adapter.HomeProjectAdapter
import com.example.android_hapdong_28th.main.home.api.RetrofitObject
import com.example.android_hapdong_28th.main.home.data.ResponseHomeProject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeProjectThirdPageFragment : Fragment() {
    private var _binding: FragmentHomeProjectThirdPageBinding? = null
    private val binding get() = _binding ?: error("View를 참조하기 위해 binding이 초기화되지 않았습니다.")

    private lateinit var homeProjectAdapter: HomeProjectAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeProjectThirdPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureProjectList()
    }

    private fun configureProjectList() {
        homeProjectAdapter = HomeProjectAdapter(requireContext())
        binding.rvSmall3.adapter = homeProjectAdapter
        getServerProjectData()
    }

    private fun getServerProjectData() {
        val call: Call<ResponseHomeProject> = RetrofitObject.TUMBLBUG_SERVICE.getHomeProject()
        call.enqueue(object : Callback<ResponseHomeProject> {
            override fun onResponse(
                call: Call<ResponseHomeProject>,
                response: Response<ResponseHomeProject>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        homeProjectAdapter.projectList = it.data.editor
                        homeProjectAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<ResponseHomeProject>, t: Throwable) {
                Log.d("tag", "t.localizedMessage!!")
            }

        })
    }
}