package com.example.tztcell.presentation.fragment.main.settings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tztcell.R
import com.example.tztcell.databinding.ListOptionBinding

class SettingsAdapter(
    private val onSaveFavoriteNews: (Int) -> Unit,
    private val value:List<String>
): RecyclerView.Adapter<SettingsAdapter.SettingsViewHolder>(){

    inner class SettingsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ListOptionBinding.bind(itemView)

        fun bind(test: String) {
            binding.apply {
                headerTitleSport.text = test
            }
            binding.root.setOnClickListener {
                onSaveFavoriteNews.invoke(adapterPosition)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingsViewHolder =
        SettingsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_option, parent, false)
        )

    override fun getItemCount() =
        value.size


    override fun onBindViewHolder(holder: SettingsViewHolder, position: Int) {
        val item = value[position]
        holder.bind(item)
    }
}