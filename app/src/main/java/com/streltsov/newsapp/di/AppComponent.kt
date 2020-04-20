package com.streltsov.newsapp.di

import com.streltsov.newsapp.di.modules.AppModule
import com.streltsov.newsapp.di.modules.DatabaseModule
import com.streltsov.newsapp.di.modules.NetworkModule
import com.streltsov.newsapp.ui.news.NewsAdapter
import com.streltsov.newsapp.ui.news.NewsItem
import com.streltsov.newsapp.ui.news.NewsViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DatabaseModule::class, NetworkModule::class])
interface AppComponent {

    fun inject(model: NewsViewModel)
    fun inject(item:NewsItem)
}