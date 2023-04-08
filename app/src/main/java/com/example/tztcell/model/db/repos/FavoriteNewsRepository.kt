package com.example.tztcell.model.db.repos

import com.example.tztcell.model.db.modelsdb.NewsFavorite
import com.example.tztcell.model.db.query.NewsFavoriteQuery
import javax.inject.Inject

class FavoriteNewsRepository @Inject constructor(private val newsFavoriteQuery: NewsFavoriteQuery) {

    fun getNewsFavotites() = newsFavoriteQuery.getNewsFavorite()

    suspend fun insertMedicine(newsFavorite: NewsFavorite) = newsFavoriteQuery.insertNewsFavorite(newsFavorite)

    suspend fun deleteNewsFavorite(news: NewsFavorite) = newsFavoriteQuery.deleteMedicineInfo(news)
}