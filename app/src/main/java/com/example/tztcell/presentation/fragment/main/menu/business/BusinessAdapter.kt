package com.example.tztcell.presentation.fragment.main.menu.business

import android.util.Log
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
import com.example.tztcell.databinding.ListBusinessBinding
import com.example.tztcell.model.db.modelsdb.NewsDb
import com.example.tztcell.model.db.modelsdb.NewsFavorite

class BusinessAdapter(
    private val onSaveFavoriteNews: (NewsFavorite) -> Unit
): ListAdapter<NewsDb, BusinessAdapter.BusinessViewHolder>(FinishDiffUtil()){

    class FinishDiffUtil : DiffUtil.ItemCallback<NewsDb>(){
        override fun areItemsTheSame(oldItem: NewsDb, newItem: NewsDb): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: NewsDb, newItem: NewsDb): Boolean {
            return oldItem == newItem
        }
    }
    inner class BusinessViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ListBusinessBinding.bind(itemView)

        fun bind(test:NewsDb ) {
            binding.apply {
                saveFavoriteNews.setOnClickListener {
                    val convert = NewsFavorite(
                        0,
                        test.title,
                        test.urlToImage,
                        test.content
                    )
                    Log.d("value","$convert")
                    onSaveFavoriteNews.invoke(convert)
                }
                contentBusiness.text = test.content
                headerTitleBusiness.text = test.title
                Glide.with(binding.root.context)
                    .load(test.urlToImage)
                    .centerCrop()
                    .transform( CenterCrop(), RoundedCorners(25))
                    .into(binding.newsImageBusiness);
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusinessViewHolder =
        BusinessViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_business, parent, false)
        )

    override fun onBindViewHolder(holder: BusinessViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}