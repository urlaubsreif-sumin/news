package com.sumin.news.repository

import android.util.Log
import com.sumin.news.data.remote.ApiRequestFactory
import com.sumin.news.data.model.NewsResponse
import com.sumin.news.data.remote.RequestCallback
import retrofit2.Call
import retrofit2.Callback
import java.lang.NullPointerException

object RequestRepository {

    private const val CLIENT_ID = "UCENCn9edaXcRiwNifHE"
    private const val CLIENT_SECRET = "8gAnsa6psO"


    fun requestNews(keyword: String, callback: RequestCallback) {

        val call = ApiRequestFactory.retrofit.requestNews(CLIENT_ID, CLIENT_SECRET, keyword)

        call.enqueue(object: Callback<NewsResponse>{

            override fun onResponse(call: Call<NewsResponse>, newsResponse: retrofit2.Response<NewsResponse>) {

                try {

                    newsResponse.body()!!.newsList.let {
                        if(it.isNotEmpty()) {
                            callback.onSuccess(it)
                        } else {
                            throw(NullPointerException())
                        }
                    }

                } catch (e: NullPointerException) {
                    callback.onError("Empty response.")
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                callback.onError(t.message ?: "Unknown Error")
            }

        })
    }
}