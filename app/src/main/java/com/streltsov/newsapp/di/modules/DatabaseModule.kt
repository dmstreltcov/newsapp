package com.streltsov.newsapp.di.modules

import android.content.Context
import androidx.room.Room
import com.streltsov.newsapp.data.AppDatabase
import com.streltsov.newsapp.model.news.ArticlesDao
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun provideDatabase(applicationContext: Context): AppDatabase {
        return Room.databaseBuilder(applicationContext, AppDatabase::class.java, "newsApp.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideArticlesDao(db: AppDatabase): ArticlesDao {
        return db.articlesDao()
    }


}