package com.example.tztcell.presentation.fragment.main.menu.business

import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.tztcell.NewsApp
import com.example.tztcell.R
import com.example.tztcell.Resource
import com.example.tztcell.databinding.FragmentBusinessBinding
import com.example.tztcell.presentation.base.BaseFragment
import com.example.tztcell.presentation.fragment.main.menu.technology.TechnologyAdapter
import com.example.tztcell.utils.NAMELANGUAGENEWS
import com.example.tztcell.utils.NAME_LANGUAGE
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BusinessFragment:BaseFragment<FragmentBusinessBinding>(R.layout.fragment_business) {
    override val binding by viewBinding(FragmentBusinessBinding::bind)
    private val viewModel : BusinessViewModel by viewModels()


    override fun initialize() {
        super.initialize()

       binding.recyclerView.apply {
           layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
           adapter = BusinessAdapter{
               lifecycleScope.launch(Dispatchers.IO) {
                   viewModel.saveFavoriteNews(it)
               }
           }
       }
        val newsLGChange =  NewsApp.sharedPreferences.getString(NAMELANGUAGENEWS,"")
        lifecycleScope.launch {
            viewModel.getNewsBusiness("f1a05bb7b5a44932b7859a0f75e8446d",newsLGChange!!,"business").observe(viewLifecycleOwner) {
                when(it){
                    is Resource.Loading ->{
                        binding.recyclerView.visibility = View.GONE
                        binding.shimmerViewContainer.visibility = View.VISIBLE
                    }
                    is Resource.Success ->{
                        binding.recyclerView.visibility = View.VISIBLE
                        binding.shimmerViewContainer.visibility = View.GONE
                        (binding.recyclerView.adapter as BusinessAdapter).submitList(it.data)
                    }
                    else -> {}
                }
            }
            }
        }
    }