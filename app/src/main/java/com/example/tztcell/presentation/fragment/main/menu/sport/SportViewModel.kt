package com.example.tztcell.presentation.fragment.main.menu.sport

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.tztcell.model.db.modelsdb.NewsFavorite
import com.example.tztcell.model.db.repos.FavoriteNewsRepository
import com.example.tztcell.model.repositories.RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SportViewModel @Inject constructor(
    private val repositoryImpl: RepositoryImpl,
    private val favoriteNewsRepository: FavoriteNewsRepository

) :ViewModel() {
    fun getNewsSport(key:String,country:String,category: String) =
        repositoryImpl.getNewsSport(key,country,category).asLiveData()


    suspend fun saveFavoriteNews(newsFavorite: NewsFavorite) = favoriteNewsRepository.insertMedicine(newsFavorite)
}