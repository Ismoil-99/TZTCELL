package com.example.tztcell.presentation.fragment.main.menu.technology

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.tztcell.R
import com.example.tztcell.databinding.FragmentTechnologyBinding
import com.example.tztcell.presentation.base.BaseFragment
import com.example.tztcell.presentation.fragment.main.menu.sport.SportAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@AndroidEntryPoint
class TechnologyFragment:BaseFragment<FragmentTechnologyBinding>(R.layout.fragment_technology) {
    override val binding by viewBinding(FragmentTechnologyBinding::bind)
    private val viewModel : TechnologyViewModel by viewModels()


    override fun initialize() {
        super.initialize()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
            adapter = TechnologyAdapter{
                lifecycleScope.launch(Dispatchers.IO){
                    viewModel.saveFavoriteNews(it)
                }
            }
        }
        lifecycleScope.launch {
            viewModel.technoNews("f1a05bb7b5a44932b7859a0f75e8446d","us","technology").observe(viewLifecycleOwner){
                (binding.recyclerView.adapter as TechnologyAdapter).submitList(it.data)
                Log.d("value","${it.error}")
            }
        }
    }
}