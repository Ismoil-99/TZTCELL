package com.example.tztcell.presentation.fragment.main.menu

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.tztcell.R
import com.example.tztcell.databinding.FragmentMenuBinding
import com.example.tztcell.presentation.base.BaseFragment
import com.example.tztcell.presentation.fragment.main.menu.viewpager.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment:BaseFragment<FragmentMenuBinding>(R.layout.fragment_menu) {
    override val binding by viewBinding(FragmentMenuBinding::bind)

    override fun initialize() {
        super.initialize()
        binding.viewPager.adapter =
            ViewPagerAdapter(requireActivity().supportFragmentManager, lifecycle)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when(position){
                0 -> tab.text = resources.getString(R.string.business)
                1 -> tab.text = resources.getString(R.string.sports)
                2 -> tab.text = resources.getString(R.string.technology)
            }
        }.attach()
    }
}