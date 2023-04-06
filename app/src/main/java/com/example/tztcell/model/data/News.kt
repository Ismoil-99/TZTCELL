package com.example.tztcell.model.data

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("articles")
    val articles:List<Articles>
)
data class Articles(
    @SerializedName("title")
    val title:String,
    @SerializedName("urlToImage")
    val urlToImage:String,
    @SerializedName("content")
    val content:String
)