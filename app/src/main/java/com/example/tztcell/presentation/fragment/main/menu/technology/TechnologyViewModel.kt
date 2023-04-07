package com.example.tztcell.presentation.fragment.main.menu.technology

import androidx.lifecycle.ViewModel
import com.example.tztcell.model.repositories.RepositoryRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class TechnologyViewModel @Inject constructor(private val repositoryRequest: RepositoryRequest) :ViewModel() {

    fun technoNews(key:String,country:String,category: String) = repositoryRequest.getSport(key,country,category)
}