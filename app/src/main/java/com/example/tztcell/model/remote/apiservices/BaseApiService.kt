package com.example.tztcell.model.remote.apiservices

import com.example.tztcell.model.data.News
import com.example.tztcell.model.data.NewsSport
import com.example.tztcell.model.data.NewsTechnology
import com.example.tztcell.model.db.modelsdb.NewsSportDb
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BaseApiService {

    @GET("v2/top-headlines")
    suspend fun getNewsBusiness(
        @Query("apiKey") apiKey:String,
        @Query("country") country:String,
        @Query("category") category:String
    ):News

    @GET("v2/top-headlines")
    suspend fun getNewsTechnology(
        @Query("apiKey") apiKey:String,
        @Query("country") country:String,
        @Query("category") category:String
    ):NewsTechnology
    @GET("v2/top-headlines")
    suspend fun getNewsSport(
        @Query("apiKey") apiKey:String,
        @Query("country") country:String,
        @Query("category") category:String
    ):NewsSport


}