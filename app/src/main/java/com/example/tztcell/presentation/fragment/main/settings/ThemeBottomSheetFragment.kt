package com.example.tztcell.presentation.fragment.main.settings

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.tztcell.R
import com.example.tztcell.databinding.FragmentThemeBottomsheetBinding
import com.example.tztcell.presentation.base.BaseBottomSheet
import com.google.android.material.bottomsheet.BottomSheetBehavior

class ThemeBottomSheetFragment: BaseBottomSheet<FragmentThemeBottomsheetBinding>(
    R.layout.fragment_theme_bottomsheet,
    BottomSheetBehavior.STATE_EXPANDED
) {
    override val binding by viewBinding(FragmentThemeBottomsheetBinding::bind)
}