package com.streltsov.newsapp.model.news

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface ArticlesDao {

    @Query("SELECT * FROM Article")
    fun getAllArticles():Single<List<Article>>

    @Query("SELECT * FROM Article WHERE id = :id")
    fun getArticleById(id: Long): Single<Article>

    @Insert
    fun insertArticles(articles: List<Article>)

    @Insert
    fun insertSource(source: Source)

}