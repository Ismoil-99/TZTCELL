package com.example.tztcell.model.db.query

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tztcell.model.db.modelsdb.NewsDb
import com.example.tztcell.model.db.modelsdb.NewsSportDb
import com.example.tztcell.model.db.modelsdb.NewsTechnologyDb
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsQueryTechnology {

    @Query("SELECT * FROM new_list_technology")
    fun getNewsTechnology(): Flow<List<NewsTechnologyDb>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsTechnology(cars: List<NewsTechnologyDb>)

    @Query("DELETE FROM  new_list_technology")
    suspend fun deleteAllTechnology()
}