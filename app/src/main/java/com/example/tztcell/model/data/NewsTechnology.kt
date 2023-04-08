package com.example.tztcell.model.data

import com.example.tztcell.model.db.modelsdb.NewsSportDb
import com.example.tztcell.model.db.modelsdb.NewsTechnologyDb
import com.google.gson.annotations.SerializedName

data class NewsTechnology(
    @SerializedName("articles")
    val articles:List<NewsTechnologyDb>
)