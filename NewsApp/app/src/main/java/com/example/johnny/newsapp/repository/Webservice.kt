package com.example.johnny.newsapp.repository

import com.example.johnny.newsapp.Constant
import com.example.johnny.newsapp.pojos.NewsResponse
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Query

interface Webservice {

    @GET(Constant.API_TOP_HEADLINES)
    fun getNewsByCountry(@Query("country") code: String, @Query("apiKey") api: String): Call<NewsResponse>

    @GET(Constant.API_TOP_HEADLINES)
    fun getNewsBySource(@Query("sources") code: String, @Query("apiKey") api: String): Call<NewsResponse>

}