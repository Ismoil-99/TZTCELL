package com.example.tztcell.presentation.fragment.main

import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.tztcell.R
import com.example.tztcell.databinding.FragmentFlowMainLayoutBinding
import com.example.tztcell.presentation.base.BaseFlowFragment

class MainFlowFragment: BaseFlowFragment(R.layout.fragment_flow_main_layout,R.id.fragment_container_view){
    private val binding by viewBinding(FragmentFlowMainLayoutBinding::bind)

    override fun setupNavigation(navController: NavController) {
        super.setupNavigation(navController)
       binding.bottomNavigation.setupWithNavController(navController)
    }
}