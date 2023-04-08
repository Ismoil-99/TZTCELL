package com.example.tztcell.model.db.module

import android.app.Application
import com.example.tztcell.model.db.database.NewsDatabase
import com.example.tztcell.model.db.modelsdb.NewsSportDb
import com.example.tztcell.model.db.query.NewsQuery
import com.example.tztcell.model.db.query.NewsQuerySport
import com.example.tztcell.model.db.query.NewsQueryTechnology
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun getAppDatabase(context: Application): NewsDatabase {
        return NewsDatabase.getAppDBInstance(context)
    }
    @Provides
    @Singleton
    fun getAppDao(appDatabase: NewsDatabase): NewsQuery {
        return appDatabase.listNews()
    }
    @Provides
    @Singleton
    fun getAppDaoSport(appDatabase: NewsDatabase): NewsQuerySport {
        return appDatabase.listNewsSport()
    }
    @Provides
    @Singleton
    fun getAppDaoTechnology(appDatabase: NewsDatabase): NewsQueryTechnology {
        return appDatabase.listNewsTechnology()
    }
}