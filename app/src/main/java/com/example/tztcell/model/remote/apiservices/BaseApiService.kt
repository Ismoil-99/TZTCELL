package com.example.tztcell.model.remote.apiservices

import com.example.tztcell.model.data.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BaseApiService {

    @GET("v2/top-headlines")
    suspend fun getNewsBusiness(
        @Query("apiKey") apiKey:String,
        @Query("country") country:String,
        @Query("category") category:String
    ):Response<News>
}