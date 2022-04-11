package com.sumin.news.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumin.news.data.model.News
import com.sumin.news.data.remote.RequestCallback
import com.sumin.news.repository.RequestRepository
import kotlinx.coroutines.launch
import java.net.URLEncoder

class NewsViewModel(): ViewModel() {

    private val _keyword = MutableLiveData<String>().apply { value = "" }
    val keyword: LiveData<String> = _keyword

    private val _newsList = MutableLiveData<List<News>>().apply { value = null }
    val newsList: LiveData<List<News>> = _newsList

    private val _isLoading = MutableLiveData<Boolean>().apply { value = false }
    val isLoading: LiveData<Boolean> = _isLoading
    private val _onError = MutableLiveData<Boolean>().apply { value = false }
    val onError: LiveData<Boolean> = _onError


    fun searchNews() {
        _isLoading.value = true

        viewModelScope.launch {

            RequestRepository.requestNews(encodeStringUTF8("코로나"), object: RequestCallback {

                override fun onSuccess(data: List<News>) {
                    _newsList.value = data

                    _onError.value = false
                    _isLoading.value = false
                }

                override fun onError(error: String) {
                    Log.d("TEST", error)

                    _onError.value = true
                    _isLoading.value = false
                }
            })
        }
    }

    private fun encodeStringUTF8(str: String)
        = URLEncoder.encode(str, "utf-8")


    fun keywordChanged(str: String?) {
        _keyword.value = str
    }
}