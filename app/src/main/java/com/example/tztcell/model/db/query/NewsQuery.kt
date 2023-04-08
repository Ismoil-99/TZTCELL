package com.example.tztcell.model.db.query

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tztcell.model.db.modelsdb.NewsDb
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsQuery {

    @Query("SELECT * FROM news_list")
    fun getNews(): Flow<List<NewsDb>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNews(cars: List<NewsDb>)

    @Query("DELETE FROM  news_list")
    suspend fun deleteAllCars()
}