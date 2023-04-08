package com.example.tztcell.model.db.modelsdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "new_list_sport")
data class NewsSportDb(
    @PrimaryKey val title:String,
    val urlToImage:String?,
    val content:String?
)