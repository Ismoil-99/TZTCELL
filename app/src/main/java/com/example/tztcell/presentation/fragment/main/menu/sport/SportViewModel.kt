package com.example.tztcell.presentation.fragment.main.menu.sport

import androidx.lifecycle.ViewModel
import com.example.tztcell.model.repositories.RepositoryRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SportViewModel @Inject constructor(private val repositoryRequest: RepositoryRequest) :ViewModel() {
    fun sportNews(key:String,country:String,category: String) = repositoryRequest.getSport(key,country,category)
}