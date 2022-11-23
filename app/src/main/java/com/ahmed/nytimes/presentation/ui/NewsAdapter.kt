package com.ahmed.nytimes.presentation.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ahmed.nytimes.R
import com.ahmed.nytimes.data.model.MostPopularModel
import com.ahmed.nytimes.databinding.NewsItemBinding

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<MostPopularModel>() {
        override fun areItemsTheSame(
            oldItem: MostPopularModel,
            newItem: MostPopularModel
        ): Boolean {
            Log.d("ahmedmohamed", "areItemsTheSame: ${oldItem.id}++ ${newItem.id}")
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: MostPopularModel,
            newItem: MostPopularModel
        ): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, callback)

    class NewsViewHolder(private val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(mostPopular: MostPopularModel) {
            binding.model=mostPopular
            binding.container.setOnClickListener {
                Log.d("Ahmed123", "bind:$mostPopular ")
//                binding.root.findNavController().navigate(R.id.action_homeFragment_to_detailsFragment)
                binding.root.findNavController()
                    .navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(mostPopular))

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = NewsItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val result = differ.currentList[position]
        holder.bind(result)
    }

    override fun getItemCount(): Int = differ.currentList.size
}