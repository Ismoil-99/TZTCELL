package com.example.tztcell.presentation.fragment.main.menu.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tztcell.presentation.fragment.main.menu.business.BusinessFragment
import com.example.tztcell.presentation.fragment.main.menu.technology.TechnologyFragment
import com.example.tztcell.presentation.fragment.main.menu.sport.SportFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }
    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return BusinessFragment()
            1 -> return TechnologyFragment()
            2 -> return SportFragment()
        }
        return SportFragment()
    }
}