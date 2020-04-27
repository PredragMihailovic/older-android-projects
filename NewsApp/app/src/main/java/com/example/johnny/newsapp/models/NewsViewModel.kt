package com.example.johnny.newsapp.models

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.johnny.newsapp.pojos.News
import com.example.johnny.newsapp.repository.NewsRepository

class NewsViewModel: ViewModel() {

    fun getDataByCountry(countryCode: String): LiveData<List<News>> {

        val repository = NewsRepository()
        var data: LiveData<List<News>>

        data = repository.getNewsByCountry(countryCode)

        return data!!
    }

    fun getDataBySource(sourceCode: String): LiveData<List<News>> {

        val repository = NewsRepository()
        var data: LiveData<List<News>>

        data = repository.getNewsBySource(sourceCode)

        return data!!
    }



}