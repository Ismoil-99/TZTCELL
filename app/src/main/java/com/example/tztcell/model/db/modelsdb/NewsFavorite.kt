package com.example.tztcell.model.db.modelsdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "list_favorite_news",indices = [Index(value = ["title"], unique = true)])
data class NewsFavorite(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    @ColumnInfo(name ="title")
    val title:String,
    val urlToImage:String?,
    val content:String?,
    val publishedAt:String?
)