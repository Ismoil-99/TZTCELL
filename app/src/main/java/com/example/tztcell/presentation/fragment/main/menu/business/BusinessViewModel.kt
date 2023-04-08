package com.example.tztcell.presentation.fragment.main.menu.business

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.tztcell.model.db.modelsdb.NewsDb
import com.example.tztcell.model.repositories.RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BusinessViewModel @Inject constructor(private val repositoryImpl: RepositoryImpl,) :ViewModel() {
    fun getNewsBusiness(key:String,country:String,category: String) =
        repositoryImpl.getNewsBusiness(key,country,category).asLiveData()
}