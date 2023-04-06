package com.example.tztcell.presentation.fragment.main.menu.business

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.tztcell.R
import com.example.tztcell.databinding.FragmentBusinessBinding
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
        lifecycleScope.launch {
            viewModel.getNewsBusiness("f1a05bb7b5a44932b7859a0f75e8446d","us","business").collectLatest {
                Log.d("business","${it}")
            }
        }
    }
}