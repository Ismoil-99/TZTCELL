package com.example.tztcell.presentation.fragment.main.settings

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.tztcell.R
import com.example.tztcell.databinding.FragmentSettingsBinding
import com.example.tztcell.presentation.base.BaseFragment
import com.example.tztcell.presentation.extensions.navigateSafely

class SettingsFragment:BaseFragment<FragmentSettingsBinding>(R.layout.fragment_settings) {
    override val binding by viewBinding(FragmentSettingsBinding::bind)


    override fun initialize() {
        super.initialize()
        val listOption = listOf("Язык","Уведомления","Язык новостей")
        binding.recyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = SettingsAdapter(
                value = listOption,
                onSaveFavoriteNews = {
                    changeOption(it)
                }
            )
        }
    }

    private fun changeOption(it: Int) {
        when(it){
            0 ->{findNavController().navigateSafely(R.id.to_languagesystem)}
            2 ->{findNavController().navigateSafely(R.id.to_languagenews)}
        }
    }
}