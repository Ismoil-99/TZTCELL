package com.example.tztcell.presentation.fragment.main.menu.business

import androidx.lifecycle.ViewModel
import com.example.tztcell.model.repositories.RepositoryRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BusinessViewModel @Inject constructor(private val repositoryRequest: RepositoryRequest) :ViewModel() {
    fun getNewsBusiness(key:String,country:String,category: String) = repositoryRequest.getBusiness(key,country,category)
}