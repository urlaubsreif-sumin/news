package com.sumin.news.data.remote

import com.sumin.news.data.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NewsApi {

    @GET("news.json")
    fun requestNews(@Header("X-Naver-Client-Id") clientId: String,
                    @Header("X-Naver-Client-Secret") clientSecret: String,
                    @Query("query") keyword: String,
                    @Query("display") display: Int? = null,
                    @Query("start") start: Int? = null): Call<NewsResponse>

}
