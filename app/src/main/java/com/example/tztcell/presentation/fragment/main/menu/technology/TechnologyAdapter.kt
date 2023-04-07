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
import com.example.tztcell.databinding.ListBusinessBinding
import com.example.tztcell.databinding.ListSportBinding
import com.example.tztcell.databinding.ListTechnologyBinding
import com.example.tztcell.model.data.Articles

class TechnologyAdapter(): ListAdapter<Articles, TechnologyAdapter.BusinessViewHolder>(FinishDiffUtil()){

    class FinishDiffUtil : DiffUtil.ItemCallback<Articles>(){
        override fun areItemsTheSame(oldItem: Articles, newItem: Articles): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Articles, newItem: Articles): Boolean {
            return oldItem == newItem
        }
    }
    inner class BusinessViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ListTechnologyBinding.bind(itemView)

        fun bind(test:Articles ) {
            binding.apply {
                contentTechnology.text = test.content
                headerTitleTechnology.text = test.title
                Glide.with(binding.root.context)
                    .load(test.urlToImage)
                    .centerCrop()
                    .transform( CenterCrop(), RoundedCorners(25))
                    .into(binding.newsImageTechnology);
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