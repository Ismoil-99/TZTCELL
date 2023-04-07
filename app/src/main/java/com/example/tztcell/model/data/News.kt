package com.example.tztcell.model.data

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("status")
    val status:String,
    @SerializedName("totalResults")
    val totalResults:Int,
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