package com.example.tztcell.presentation.fragment.main.menu.technology

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.tztcell.model.repositories.RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class TechnologyViewModel @Inject  constructor(private val  repositoryImpl: RepositoryImpl):ViewModel() {

    fun technoNews(key:String,country:String,category: String) = repositoryImpl.getNewsTechnology(key,country,category).asLiveData()
}