package com.sumin.news.data.model

data class NewsResponse(
    val lastBuildDate: String,
    val total: Int,
    val start: Int,
    val display: Int,
    val newsList: List<News>
)