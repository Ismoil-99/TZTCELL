package com.example.tztcell.model.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tztcell.model.db.modelsdb.NewsFavorite
import com.example.tztcell.model.db.modelsdb.NewsDb
import com.example.tztcell.model.db.modelsdb.NewsSportDb
import com.example.tztcell.model.db.modelsdb.NewsTechnologyDb
import com.example.tztcell.model.db.query.NewsFavoriteQuery
import com.example.tztcell.model.db.query.NewsQuery
import com.example.tztcell.model.db.query.NewsQuerySport
import com.example.tztcell.model.db.query.NewsQueryTechnology

@Database(entities = [NewsDb::class,NewsSportDb::class,NewsTechnologyDb::class, NewsFavorite::class], version = 13, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun listNews(): NewsQuery
    abstract fun listNewsSport(): NewsQuerySport
    abstract fun listNewsTechnology():NewsQueryTechnology
    abstract fun listNewsFavorite():NewsFavoriteQuery
    companion object{
        private var DB_INSTANCE: NewsDatabase? = null
        fun getAppDBInstance(context: Context): NewsDatabase {
            if (DB_INSTANCE == null) {
                DB_INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    NewsDatabase::class.java,
                    "news",
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return DB_INSTANCE!!
        }
    }
}