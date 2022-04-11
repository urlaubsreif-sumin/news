package com.sumin.news.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.sumin.news.R
import com.sumin.news.viewmodel.NewsViewModel

class MainActivity : AppCompatActivity() {
    private val newsViewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        newsLoadingTest()
        newsViewModel.searchNews()
    }

    private fun newsLoadingTest() {
        newsViewModel.newsList.observe(this){
            it?.forEach { news ->
                Log.d("TEST", news.title)
            }

        }
    }
}