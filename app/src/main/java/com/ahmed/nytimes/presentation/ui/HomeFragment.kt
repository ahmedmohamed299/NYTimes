package com.ahmed.nytimes.presentation.ui

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.ahmed.nytimes.R
import com.ahmed.nytimes.data.utils.Resource
import com.ahmed.nytimes.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val adapter = NewsAdapter()
    private lateinit var viewModel: NewsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        viewModel=(activity as MainActivity).viewModel
        initRecycler()
        onBackPressed()

        return binding.root
    }

    private fun initRecycler() {
        binding.newsRecycler.adapter=adapter
        viewModel.getNewsFromApis().observe(viewLifecycleOwner){

            when (it){

                is Resource.Loading ->{
                    Toast.makeText(requireActivity(), "loading", Toast.LENGTH_LONG).show()
                }
                is Resource.Success ->{
                    it.data?.let { mostPopularModelList ->
                        adapter.differ.submitList(mostPopularModelList.toList())
                    }

                }
                is Resource.Error ->{
                    Log.d("ResourceError", "Error:${it.message} ")

                }
            }
        }
    }

       private fun onBackPressed() {

        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (Navigation
                        .findNavController(requireActivity(), R.id.fragment_container_view)
                        .currentDestination?.id == R.id.homeFragment
                ) {

                    requireActivity().finish()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            requireActivity(),
            onBackPressedCallback
        )

    }

}
