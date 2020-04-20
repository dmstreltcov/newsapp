package com.streltsov.newsapp.network

import com.streltsov.newsapp.model.news.Article

data class ApiResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
){
    override fun toString(): String {
        return """
            status is: $status \n
            totalResults is: $totalResults\n
            articles is: ${articles.take(5)}
        
        }
        """.trimIndent()
    }
}