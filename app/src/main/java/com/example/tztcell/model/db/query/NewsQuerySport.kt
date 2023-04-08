package com.example.tztcell.model.db.query

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tztcell.model.db.modelsdb.NewsDb
import com.example.tztcell.model.db.modelsdb.NewsSportDb
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsQuerySport {

    @Query("SELECT * FROM new_list_sport")
    fun getNewsSport(): Flow<List<NewsSportDb>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsSport(cars: List<NewsSportDb>)

    @Query("DELETE FROM  new_list_sport")
    suspend fun deleteAllSport()
}