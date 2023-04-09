package com.example.tztcell.presentation.fragment.main.menu.sport

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.tztcell.NewsApp
import com.example.tztcell.R
import com.example.tztcell.Resource
import com.example.tztcell.databinding.FragmentSportBinding
import com.example.tztcell.presentation.base.BaseFragment
import com.example.tztcell.presentation.fragment.main.menu.technology.TechnologyAdapter
import com.example.tztcell.utils.NAMELANGUAGENEWS
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SportFragment:BaseFragment<FragmentSportBinding>(R.layout.fragment_sport) {
    override val binding by viewBinding(FragmentSportBinding::bind)
    private val viewModel : SportViewModel by viewModels()

    override fun initialize() {
        super.initialize()
        binding.recyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = SportAdapter{
                lifecycleScope.launch (Dispatchers.IO){
                    viewModel.saveFavoriteNews(it)
                }
            }
        }
        val newsLGChange =  NewsApp.sharedPreferences.getString(NAMELANGUAGENEWS,"")

        lifecycleScope.launch {
            viewModel.getNewsSport("f1a05bb7b5a44932b7859a0f75e8446d",newsLGChange!!,"sport").observe(viewLifecycleOwner){
                when(it){
                    is Resource.Loading ->{
                        binding.recyclerView.visibility = View.GONE
                        binding.shimmerViewContainer.visibility = View.VISIBLE
                    }
                    is Resource.Success ->{
                        binding.recyclerView.visibility = View.VISIBLE
                        binding.shimmerViewContainer.visibility = View.GONE
                        (binding.recyclerView.adapter as SportAdapter).submitList(it.data)
                    }
                    else -> {}
                }
            }
        }
    }

}