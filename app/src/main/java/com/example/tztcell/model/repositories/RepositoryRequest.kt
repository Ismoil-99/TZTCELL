package com.example.tztcell.model.repositories

import com.example.tztcell.model.Resource
import com.example.tztcell.model.data.News
import kotlinx.coroutines.flow.Flow

interface RepositoryRequest {
    fun getBusiness(key:String,country:String,category: String):Flow<Resource<News>>
    fun getTechnology(key:String,country:String,category: String):Flow<Resource<News>>
    fun getSport(key:String,country:String,category: String):Flow<Resource<News>>
}