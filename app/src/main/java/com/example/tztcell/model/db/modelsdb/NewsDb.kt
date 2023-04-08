package com.example.tztcell.model.db.modelsdb

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "news_list")
data class NewsDb(
    @PrimaryKey val title:String,
    val urlToImage:String?,
    val content:String?
)