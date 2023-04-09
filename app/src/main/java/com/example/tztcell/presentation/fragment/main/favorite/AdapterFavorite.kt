package com.example.tztcell.presentation.fragment.main.favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.tztcell.R
import com.example.tztcell.databinding.ListFavoriteBinding
import com.example.tztcell.model.db.modelsdb.NewsFavorite

class AdapterFavorite(): ListAdapter<NewsFavorite, AdapterFavorite.BusinessViewHolder>(FinishDiffUtil()){

    class FinishDiffUtil : DiffUtil.ItemCallback<NewsFavorite>(){
        override fun areItemsTheSame(oldItem: NewsFavorite, newItem: NewsFavorite): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: NewsFavorite, newItem: NewsFavorite): Boolean {
            return oldItem == newItem
        }
    }
    inner class BusinessViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ListFavoriteBinding.bind(itemView)

        fun bind(test: NewsFavorite) {
            binding.apply {
                contentTechnology.text = test.content
                headerTitleTechnology.text = test.title
                Glide.with(binding.root.context)
                    .load(test.urlToImage)
                    .centerCrop()
                    .transform( CenterCrop(), RoundedCorners(25))
                    .into(binding.newsImageTechnology);
                timePublish.text = test.publishedAt
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusinessViewHolder =
        BusinessViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_favorite, parent, false)
        )

    override fun onBindViewHolder(holder: BusinessViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}