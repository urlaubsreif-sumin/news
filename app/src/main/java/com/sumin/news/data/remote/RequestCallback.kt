package com.sumin.news.data.remote

import com.sumin.news.data.model.News

interface RequestCallback {
    fun onSuccess(data: List<News>)
    fun onError(error: String)
}