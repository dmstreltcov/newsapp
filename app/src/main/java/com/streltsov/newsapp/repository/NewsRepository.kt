package com.streltsov.newsapp.repository

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.streltsov.newsapp.model.news.Article
import com.streltsov.newsapp.model.news.ArticlesDao
import com.streltsov.newsapp.network.NewsClient
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsClient: NewsClient,
    private val articlesDao: ArticlesDao
) : Repository {
    override var isLoading: Boolean = false
    @SuppressLint("CheckResult")
    fun getNewsByCountryAndCategory(
        country: String? = null,
        category: String? = null,
        source: String? = null,
        apiKey: String
    ): MutableLiveData<List<Article>> {
        var liveData = MutableLiveData<List<Article>>()
        articlesDao.getAllArticles()
            .subscribeOn(Schedulers.io())
            .subscribe { it ->
                if (it.isNullOrEmpty()) {
                    newsClient.getNewsByCountryAndCategory(country, category, source, apiKey)
                        .subscribeOn(Schedulers.io())
                        .subscribe {
                            Log.d("Api response", it.toString())
                            liveData.postValue(it.articles)
                            articlesDao.insertArticles(it.articles)
                        }
                } else {
                    liveData.postValue(it)
                }
            }
        return liveData
    }


}