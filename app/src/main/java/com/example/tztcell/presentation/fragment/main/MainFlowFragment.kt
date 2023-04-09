package com.example.tztcell.presentation.fragment.main

import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.tztcell.R
import com.example.tztcell.databinding.FragmentFlowMainLayoutBinding
import com.example.tztcell.presentation.base.BaseFlowFragment
import com.example.tztcell.presentation.extensions.hideArrowTool
import com.google.android.material.appbar.MaterialToolbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFlowFragment: BaseFlowFragment(R.layout.fragment_flow_main_layout,R.id.fragment_container_view){
    private val binding by viewBinding(FragmentFlowMainLayoutBinding::bind)

    override fun setupNavigation(navController: NavController) {
        super.setupNavigation(navController)
       binding.bottomNavigation.setupWithNavController(navController)

        NavigationUI.setupWithNavController(requireActivity().findViewById(R.id.toolbar),navController,null)
        navController.addOnDestinationChangedListener{_,destination,_ ->
            when(destination.id){
                R.id.favorite -> {
                    hideArrowTool()
                }
                R.id.settings ->{
                    hideArrowTool()
                }
                else ->{
            }
            }
        }
    }
}