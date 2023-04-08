package com.example.tztcell.presentation.fragment.main.menu.sport

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.tztcell.model.repositories.RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SportViewModel @Inject constructor(private val repositoryImpl: RepositoryImpl) :ViewModel() {
    fun getNewsSport(key:String,country:String,category: String) =
        repositoryImpl.getNewsSport(key,country,category).asLiveData()
}