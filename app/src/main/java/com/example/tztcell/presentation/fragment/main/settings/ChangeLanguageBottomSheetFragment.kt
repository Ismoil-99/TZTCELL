package com.example.tztcell.presentation.fragment.main.settings

import android.content.res.Configuration
import android.os.Build
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.tztcell.NewsApp
import com.example.tztcell.R
import com.example.tztcell.databinding.FragmentChangeLanguageBottomsheetBinding
import com.example.tztcell.presentation.base.BaseBottomSheet
import com.example.tztcell.utils.NAME_LANGUAGE
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.coroutines.launch
import java.util.*

class ChangeLanguageBottomSheetFragment:BaseBottomSheet<FragmentChangeLanguageBottomsheetBinding>(
    R.layout.fragment_change_language_bottomsheet,
    BottomSheetBehavior.STATE_EXPANDED
) {
    override val binding by viewBinding(FragmentChangeLanguageBottomsheetBinding::bind)
    private lateinit var navController: NavController

    override fun initialize() {
        super.initialize()
        when(NewsApp.sharedPreferences.getString(NAME_LANGUAGE,"")){
            "ru" -> {
                binding.apply {
                    ru.setImageResource(R.drawable.baseline_star_24)
                    tjk.setImageResource(R.drawable.baseline_star_outline_24)
                    eng.setImageResource(R.drawable.baseline_star_outline_24)
                }
            }
            "tg" -> {
                binding.apply {
                    ru.setImageResource(R.drawable.baseline_star_outline_24)
                    tjk.setImageResource(R.drawable.baseline_star_24)
                    eng.setImageResource(R.drawable.baseline_star_outline_24)
                }
            }
            "en" -> {
                binding.apply {
                    ru.setImageResource(R.drawable.baseline_star_outline_24)
                    tjk.setImageResource(R.drawable.baseline_star_outline_24)
                    eng.setImageResource(R.drawable.baseline_star_24)
                }
            }
            else -> {
                binding.apply {
                    ru.setImageResource(R.drawable.baseline_star_outline_24)
                    tjk.setImageResource(R.drawable.baseline_star_outline_24)
                    eng.setImageResource(R.drawable.baseline_star_outline_24)
                }
            }}
            binding.apply {
                selectRu.setOnClickListener {
                    setLanguage("ru")
                }
                selectEng.setOnClickListener {
                    setLanguage("en")
                }
                selectTjk.setOnClickListener {
                    setLanguage("tg")
                }
            }
    }
    private fun setLanguage(language: String) {
        val saveLg = NewsApp.sharedPreferencesEditor.putString(NAME_LANGUAGE,language)
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration()
        @SuppressWarnings("deprecation")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            config.setLocale(locale)
        } else {
            config.locale = locale
        }
        requireActivity().baseContext.resources
            .updateConfiguration(config, requireActivity().baseContext.resources.displayMetrics)
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