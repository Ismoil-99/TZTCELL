package com.example.tztcell.presentation.fragment.main.favorite

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.tztcell.R
import com.example.tztcell.databinding.FragmentFavoriteBinding
import com.example.tztcell.presentation.base.BaseFragment
import com.example.tztcell.presentation.fragment.main.menu.business.BusinessAdapter
import com.example.tztcell.presentation.fragment.main.menu.business.BusinessViewModel
import com.example.tztcell.presentation.fragment.main.menu.technology.TechnologyAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class FavoriteFragment:BaseFragment<FragmentFavoriteBinding>(R.layout.fragment_favorite) {
    override val binding by viewBinding(FragmentFavoriteBinding::bind)
    private val viewModel : FavoriteViewModel by viewModels()


    override fun initialize() {
        super.initialize()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
            adapter = AdapterFavorite()
        }
        lifecycleScope.launch {
            viewModel.getAllNewsFavorite().collectLatest {
                (binding.recyclerView.adapter as AdapterFavorite).submitList(it)
            }
        }
    }
    }