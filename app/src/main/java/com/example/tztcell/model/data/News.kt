package com.example.tztcell.model.data

import com.example.tztcell.model.db.modelsdb.NewsDb
import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("articles")
    val articles:List<NewsDb>
)