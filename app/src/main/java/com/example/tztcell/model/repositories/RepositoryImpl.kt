package com.example.tztcell.model.repositories

import androidx.room.withTransaction
import com.example.tztcell.model.db.database.NewsDatabase
import com.example.tztcell.model.db.modelsdb.NewsDb
import com.example.tztcell.model.db.modelsdb.NewsSportDb
import com.example.tztcell.model.remote.apiservices.BaseApiService
import kotlinx.coroutines.delay
import networkBoundResource
import javax.inject.Inject

class RepositoryImpl @Inject constructor (private val baseApiService: BaseApiService,
                                          private val newsDatabase: NewsDatabase){
    private val newsDao = newsDatabase.listNews()
    private val newDaoSport = newsDatabase.listNewsSport()
    private val newsTechnology = newsDatabase.listNewsTechnology()

    fun getNewsBusiness(key: String, country: String, category: String) = networkBoundResource(
        query = {
            newsDao.getNews()
        },
        fetch = {
            delay(2000)
            baseApiService.getNewsBusiness(key, country, category).articles
        },
        saveFetchResult = { CarList ->
            newsDatabase.withTransaction {
                newsDao.deleteAllCars()
                newsDao.insertNews(CarList)
            }
        }
    )

    fun getNewsSport(key: String, country: String, category: String) = networkBoundResource(
        query = {
            newDaoSport.getNewsSport()
        },
        fetch = {
            delay(2000)
            baseApiService.getNewsSport(key, country, category).articles
        },
        saveFetchResult = { CarList ->
            newsDatabase.withTransaction {
                newDaoSport.deleteAllSport()
                newDaoSport.insertNewsSport(CarList)
            }
        }
    )
    fun getNewsTechnology(key: String, country: String, category: String) = networkBoundResource(
        query = {
            newsTechnology.getNewsTechnology()
        },
        fetch = {
            delay(2000)
            baseApiService.getNewsTechnology(key, country, category).articles
        },
        saveFetchResult = { CarList ->
            newsDatabase.withTransaction {
                newsTechnology.deleteAllTechnology()
                newsTechnology.insertNewsTechnology(CarList)
            }
        }
    )
}