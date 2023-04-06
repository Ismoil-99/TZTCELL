package com.example.tztcell.model.repositories

import com.example.tztcell.model.data.News
import kotlinx.coroutines.flow.Flow

interface RepositoryRequest {
    fun getBusiness(key:String,country:String,category: String):Flow<News>
}