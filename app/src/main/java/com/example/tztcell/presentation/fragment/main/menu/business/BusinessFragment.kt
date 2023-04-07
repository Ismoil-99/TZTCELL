package com.example.tztcell.presentation.fragment.main.menu.business

import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.tztcell.R
import com.example.tztcell.databinding.FragmentBusinessBinding
import com.example.tztcell.model.Resource
import com.example.tztcell.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BusinessFragment:BaseFragment<FragmentBusinessBinding>(R.layout.fragment_business) {
    override val binding by viewBinding(FragmentBusinessBinding::bind)
    private val viewModel : BusinessViewModel by viewModels()

    override fun initialize() {
        super.initialize()

       binding.recyclerView.apply {
           layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
           adapter = BusinessAdapter()
       }

        lifecycleScope.launch {
            viewModel.getNewsBusiness("f1a05bb7b5a44932b7859a0f75e8446d","us","business").collectLatest {
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
                        (binding.recyclerView.adapter as BusinessAdapter).submitList(it.data?.articles)
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