package com.example.tztcell.model.data

import com.example.tztcell.model.db.modelsdb.NewsSportDb
import com.google.gson.annotations.SerializedName

data class NewsSport(
    @SerializedName("articles")
    val articles:List<NewsSportDb>
)