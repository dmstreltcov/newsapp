package com.streltsov.newsapp.di.modules

import android.content.Context
import com.streltsov.newsapp.App
import com.streltsov.newsapp.model.news.ArticlesDao
import com.streltsov.newsapp.network.NewsClient
import com.streltsov.newsapp.repository.NewsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule() {

    @Provides
    @Singleton
    fun provideAppContext(): Context {
        return App.applicationContext()
    }

    @Provides
    fun provideNewsRepository(
        newsClient: NewsClient, articlesDao: ArticlesDao
    ): NewsRepository {
        return NewsRepository(newsClient, articlesDao)
    }

}