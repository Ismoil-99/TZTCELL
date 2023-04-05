package com.example.tztcell.presentation.fragment.main.menu

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.tztcell.R
import com.example.tztcell.databinding.FragmentMenuBinding
import com.example.tztcell.presentation.base.BaseFragment

class MenuFragment:BaseFragment<FragmentMenuBinding>(R.layout.fragment_menu) {
    override val binding by viewBinding(FragmentMenuBinding::bind)
}