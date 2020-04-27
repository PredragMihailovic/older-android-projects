package com.example.johnny.newsapp.repository


import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.johnny.newsapp.Constant
import com.example.johnny.newsapp.pojos.News
import com.example.johnny.newsapp.pojos.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class NewsRepository {

    private val service: Webservice

    init{
        val retrofit = Retrofit.Builder()
                .baseUrl(Constant.API_BASE)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        service = retrofit.create(Webservice::class.java)
    }


     fun getNewsByCountry(code: String): LiveData<List<News>>{

         val call = service.getNewsByCountry(code, Constant.API_KEY)
         var data = MutableLiveData<List<News>>()


         call.enqueue(object : Callback<NewsResponse> {
                 override fun onFailure(call: Call<NewsResponse>?, t: Throwable?) {
                     Log.v("retrofit", "call failed")
                 }
                 override fun onResponse(call: Call<NewsResponse>?, response: Response<NewsResponse>?) {
                     data.value = response!!.body()!!.articles
                 }

             })

         return data
    }

    fun getNewsBySource(code: String): LiveData<List<News>>{

        val call = service.getNewsBySource(code, Constant.API_KEY)
        var data = MutableLiveData<List<News>>()


        call.enqueue(object : Callback<NewsResponse> {
                override fun onFailure(call: Call<NewsResponse>?, t: Throwable?) {
                    Log.v("retrofit", "call failed")
                }

                override fun onResponse(call: Call<NewsResponse>?, response: Response<NewsResponse>?) {
                    data.value = response!!.body()!!.articles
                }

            })

        return data
    }



}