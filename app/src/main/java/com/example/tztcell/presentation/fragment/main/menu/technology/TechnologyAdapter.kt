package com.example.tztcell.presentation.fragment.main.menu.technology

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.bitmap.TransformationUtils.centerCrop
import com.example.tztcell.R
import com.example.tztcell.databinding.ListTechnologyBinding
import com.example.tztcell.model.db.modelsdb.NewsDb
import com.example.tztcell.model.db.modelsdb.NewsFavorite
import com.example.tztcell.model.db.modelsdb.NewsTechnologyDb

class TechnologyAdapter(
    private val onSaveFavoriteNews: (NewsFavorite) -> Unit
): ListAdapter<NewsTechnologyDb, TechnologyAdapter.BusinessViewHolder>(FinishDiffUtil()){

    class FinishDiffUtil : DiffUtil.ItemCallback<NewsTechnologyDb>(){
        override fun areItemsTheSame(oldItem: NewsTechnologyDb, newItem: NewsTechnologyDb): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: NewsTechnologyDb, newItem: NewsTechnologyDb): Boolean {
            return oldItem == newItem
        }
    }
    inner class BusinessViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ListTechnologyBinding.bind(itemView)

        fun bind(test:NewsTechnologyDb ) {
            binding.apply {
                onsaveNewsFavorite.setOnClickListener {
                    val convert = NewsFavorite(
                        0,
                        test.title,
                        test.urlToImage,
                        test.content,
                        test.publishedAt
                    )
                    onSaveFavoriteNews.invoke(convert)
                }
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
                .inflate(R.layout.list_technology, parent, false)
        )

    override fun onBindViewHolder(holder: BusinessViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}