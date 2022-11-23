package com.ahmed.nytimes.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.ahmed.nytimes.R
import com.ahmed.nytimes.data.utils.Resource
import com.ahmed.nytimes.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val adapter = NewsAdapter()
    private lateinit var viewModel: NewsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
//            findNavController().navigate(R.id.action_homeFragment_to_detailsFragment)
        viewModel=(activity as MainActivity).viewModel
        initRecycler()

        return binding.root
    }

    private fun initRecycler() {
        binding.newsRecycler.adapter=adapter
        viewModel.getNewsFromApis().observe(viewLifecycleOwner){
            Log.d("ahmed123", "initRecycler: ")

            when (it){

                is Resource.Loading ->{
                    Toast.makeText(requireActivity(), "loading", Toast.LENGTH_LONG).show()
                }
                is Resource.Success ->{
                    Log.d("Ahmed123", "Success: ")
                    it.data?.let {
                        adapter.differ.submitList(it.toList())
                    }

                }
                is Resource.Error ->{
                    Log.d("Ahmed123", "Error:${it.message} ")

                }
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}