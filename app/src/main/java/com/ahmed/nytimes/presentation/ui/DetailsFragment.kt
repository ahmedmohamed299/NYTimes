package com.ahmed.nytimes.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ahmed.nytimes.R


class DetailsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val newsModel = DetailsFragmentArgs.fromBundle(requireArguments()).news
        Log.d("Ahmed123", "onCreateView: $newsModel ")
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() = DetailsFragment()
    }
}