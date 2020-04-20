package com.streltsov.newsapp.ui.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.streltsov.newsapp.App
import com.streltsov.newsapp.model.news.Article
import com.streltsov.newsapp.repository.NewsRepository
import javax.inject.Inject

class NewsViewModel : ViewModel() {

    @Inject
    lateinit var newsRepository: NewsRepository

    init {
        App.appComponent().inject(this)
    }

    var articleList: MutableLiveData<List<Article>> = newsRepository.getNewsByCountryAndCategory(
        country = "ru",
        apiKey = "33646153e4fa419188b218331e781cd8"
    )

}