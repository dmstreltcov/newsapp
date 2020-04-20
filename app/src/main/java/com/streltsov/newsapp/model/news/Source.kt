package com.streltsov.newsapp.model.news

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Source(
    @PrimaryKey(autoGenerate = true)
    val articleId:Long,
    val id: String,
    val name: String
)