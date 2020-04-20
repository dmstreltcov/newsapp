package com.streltsov.newsapp.model.news

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.time.ZonedDateTime
import java.util.*

@Entity
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)


fun Article.formatDate(date:String): String {
    return SimpleDateFormat("dd MMMM", Locale.getDefault())
        .format(SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(date))
}

