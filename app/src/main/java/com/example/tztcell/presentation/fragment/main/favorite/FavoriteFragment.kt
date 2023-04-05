package com.example.tztcell.presentation.fragment.main.favorite

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.tztcell.R
import com.example.tztcell.databinding.FragmentFavoriteBinding
import com.example.tztcell.presentation.base.BaseFragment

class FavoriteFragment:BaseFragment<FragmentFavoriteBinding>(R.layout.fragment_favorite) {
    override val binding by viewBinding(FragmentFavoriteBinding::bind)
}