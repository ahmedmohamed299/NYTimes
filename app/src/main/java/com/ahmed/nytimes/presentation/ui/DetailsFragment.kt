package com.ahmed.nytimes.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.ahmed.nytimes.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding=FragmentDetailsBinding.inflate(inflater,container,false)
        val newsModel = DetailsFragmentArgs.fromBundle(requireArguments()).news
        Log.d("Ahmed123", "onCreateView: $newsModel ")
        binding.wvInfo.apply {
            webViewClient = WebViewClient()
            newsModel?.url?.let {
                loadUrl(newsModel.url!!)
            }


        }

        return binding.root
    }

}