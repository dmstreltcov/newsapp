package com.streltsov.newsapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.streltsov.newsapp.model.news.Article
import com.streltsov.newsapp.model.news.ArticlesDao
import com.streltsov.newsapp.model.news.Source

@Database(entities = [Article::class, Source::class], version = 4, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun articlesDao(): ArticlesDao
}