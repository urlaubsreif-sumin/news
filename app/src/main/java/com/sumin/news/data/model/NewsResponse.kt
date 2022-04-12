package com.sumin.news.data.model

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("lastBuildDate") val lastBuildDate: String,
    @SerializedName("total") val total: Int,
    @SerializedName("start") val start: Int,
    @SerializedName("display") val display: Int,
    @SerializedName("items") val newsList: List<News>
)