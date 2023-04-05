package com.example.tztcell.presentation.fragment.main.settings

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.tztcell.R
import com.example.tztcell.databinding.FragmentSettingsBinding
import com.example.tztcell.presentation.base.BaseFragment

class SettingsFragment:BaseFragment<FragmentSettingsBinding>(R.layout.fragment_settings) {
    override val binding by viewBinding(FragmentSettingsBinding::bind)
}