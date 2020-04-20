package com.streltsov.newsapp.network

import io.reactivex.Observable
import org.jetbrains.annotations.NotNull
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsClient {

    @GET("top-headlines")
    fun getNewsByCountryAndCategory(
        @Query("country") country: String? = null,
        @Query("category") category: String? = null,
        @Query("sources") sources: String? = null,
        @NotNull @Query("apiKey") apiKey: String
    ): Observable<ApiResponse>


}