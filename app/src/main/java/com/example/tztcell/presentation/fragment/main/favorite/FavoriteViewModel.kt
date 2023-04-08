package com.example.tztcell.presentation.fragment.main.favorite

import androidx.lifecycle.ViewModel
import com.example.tztcell.model.db.modelsdb.NewsFavorite
import com.example.tztcell.model.db.repos.FavoriteNewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class FavoriteViewModel  @Inject constructor(private val favoriteNewsRepository: FavoriteNewsRepository) :ViewModel() {
    fun getAllNewsFavorite() = favoriteNewsRepository.getNewsFavotites()
    suspend fun  deleteNewsFavorite(newsFavorite: NewsFavorite) = favoriteNewsRepository.insertMedicine(newsFavorite)
}