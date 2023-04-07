package com.example.tztcell.presentation.fragment.main.menu.technology

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.tztcell.R
import com.example.tztcell.databinding.FragmentTechnologyBinding
import com.example.tztcell.model.Resource
import com.example.tztcell.presentation.base.BaseFragment
import com.example.tztcell.presentation.fragment.main.menu.business.BusinessAdapter
import com.example.tztcell.presentation.fragment.main.menu.business.BusinessViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class TechnologyFragment:BaseFragment<FragmentTechnologyBinding>(R.layout.fragment_technology) {
    override val binding by viewBinding(FragmentTechnologyBinding::bind)
    private val viewModel : TechnologyViewModel by viewModels()


    override fun initialize() {
        super.initialize()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
            adapter = TechnologyAdapter()
        }
        lifecycleScope.launch {
            viewModel.technoNews("f1a05bb7b5a44932b7859a0f75e8446d","us","technology").collectLatest {
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
                        (binding.recyclerView.adapter as TechnologyAdapter).submitList(it.data?.articles)
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