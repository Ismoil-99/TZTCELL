package com.example.tztcell.model.db.query

import androidx.room.*
import com.example.tztcell.model.db.modelsdb.NewsFavorite
import kotlinx.coroutines.flow.Flow


@Dao
interface NewsFavoriteQuery {

    @Query("SELECT * FROM list_favorite_news")
    fun getNewsFavorite(): Flow<List<NewsFavorite>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsFavorite(news: NewsFavorite)

    @Delete
    suspend fun deleteMedicineInfo(news: NewsFavorite)
}