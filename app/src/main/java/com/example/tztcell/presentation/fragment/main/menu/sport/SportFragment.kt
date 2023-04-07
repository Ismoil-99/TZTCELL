package com.example.tztcell.presentation.fragment.main.menu.sport

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.tztcell.R
import com.example.tztcell.databinding.FragmentSportBinding
import com.example.tztcell.model.Resource
import com.example.tztcell.presentation.base.BaseFragment
import com.example.tztcell.presentation.fragment.main.menu.business.BusinessAdapter
import com.example.tztcell.presentation.fragment.main.menu.business.BusinessViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SportFragment:BaseFragment<FragmentSportBinding>(R.layout.fragment_sport) {
    override val binding by viewBinding(FragmentSportBinding::bind)
    private val viewModel : SportViewModel by viewModels()

    override fun initialize() {
        super.initialize()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
            adapter = SportAdapter()
        }
        lifecycleScope.launch {
            viewModel.sportNews("f1a05bb7b5a44932b7859a0f75e8446d","us","sport").collectLatest {
                when(it){
                    is Resource.Loading ->{
                        binding.apply {
                            shimmerViewContainer.startShimmer()
                            shimmerViewContainer.visibility = View.VISIBLE
                            recyclerView.visibility = View.GONE
                        }
                        //Log.d("value","${it.data}")
                    }
                    is Resource.Success -> {
                        binding.apply {
                            shimmerViewContainer.stopShimmer()
                            shimmerViewContainer.visibility = View.GONE
                            recyclerView.visibility = View.VISIBLE
                        }
                        // Log.d("value","${it.data}")
                        (binding.recyclerView.adapter as SportAdapter).submitList(it.data?.articles)
                    }
                    is Resource.Error ->{
                        //Log.d("value","${it.message}")
                    }
                    else -> {}
                }
            }
        }
    }

}