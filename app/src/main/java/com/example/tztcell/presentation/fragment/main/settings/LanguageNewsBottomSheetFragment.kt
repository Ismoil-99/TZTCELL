package com.example.tztcell.presentation.fragment.main.settings

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.tztcell.NewsApp
import com.example.tztcell.R
import com.example.tztcell.databinding.FragmentLanguageNewsBottomsheetBinding
import com.example.tztcell.presentation.base.BaseBottomSheet
import com.example.tztcell.utils.NAMELANGUAGENEWS
import com.example.tztcell.utils.NAME_LANGUAGE
import com.google.android.material.bottomsheet.BottomSheetBehavior

class LanguageNewsBottomSheetFragment: BaseBottomSheet<FragmentLanguageNewsBottomsheetBinding>(
    R.layout.fragment_language_news_bottomsheet,
    BottomSheetBehavior.STATE_EXPANDED
) {
    private lateinit var navController:NavController
    override val binding by viewBinding(FragmentLanguageNewsBottomsheetBinding::bind)

    override fun initialize() {
        super.initialize()

        binding.frSelect.setOnClickListener {
            saveNews("fr")
        }
        binding.caSelect.setOnClickListener {
            saveNews("ca")
        }
        binding.unSelect.setOnClickListener {
            saveNews("us")
        }
        binding.ruSelect.setOnClickListener {
            saveNews("ru")
        }
        binding.usSelect.setOnClickListener {
            saveNews("us")
        }
    }

    private fun saveNews(value:String) {
        val saveLg = NewsApp.sharedPreferencesEditor.putString(NAMELANGUAGENEWS,value)
        saveLg.apply()

        val navHostFragment =
            requireActivity().supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        navController = navHostFragment.navController
        val inflater = navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_graph_global).apply {
            setStartDestination(R.id.mainFlowFragment)
        }
        navController.graph = graph
    }
}