package com.example.tztcell.presentation.activity

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.lifecycle.asLiveData
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.tztcell.NewsApp
import com.example.tztcell.R
import com.example.tztcell.presentation.extensions.hideArrowTool
import com.example.tztcell.utils.NAME_LANGUAGE
import com.google.android.material.appbar.MaterialToolbar
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val getLg = NewsApp.sharedPreferences.getString(NAME_LANGUAGE,"")
        setLanguage(getLg)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        setupNavigation()

    }
    private fun setLanguage(lg: String?) {
        val locale = Locale(lg!!)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        navController = navHostFragment.navController
        val inflater = navController.navInflater

        val graph = inflater.inflate(R.navigation.nav_graph_global).apply {
            setStartDestination(R.id.mainFlowFragment)
        }
        navController.graph = graph
        navController.addOnDestinationChangedListener{_,destination,_ ->
            when(destination.id){
                R.id.mainFlowFragment -> {
                    findViewById<MaterialToolbar>(R.id.toolbar).title = ""
                }
                else ->{
                }
            }
        }

        NavigationUI.setupWithNavController(findViewById(R.id.toolbar), navController, null)
    }
}