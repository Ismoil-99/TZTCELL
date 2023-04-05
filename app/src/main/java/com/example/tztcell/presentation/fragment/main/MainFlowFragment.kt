package com.example.tztcell.presentation.fragment.main

import androidx.navigation.NavController
import com.example.tztcell.R
import com.example.tztcell.presentation.base.BaseFlowFragment

class MainFlowFragment: BaseFlowFragment(R.layout.fragment_flow_main_layout,R.id.fragment_container_view){
    override fun setupNavigation(navController: NavController) {
        super.setupNavigation(navController)
        //NavigationUI.setupWithNavController(requireActivity().findViewById(R.id.toolbar),navController,null)
    }
}