package com.example.tztcell.model.db.modelsdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list_favorite_news")
data class NewsFavorite(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    val title:String,
    val urlToImage:String?,
    val content:String?,
    val publishedAt:String?
)