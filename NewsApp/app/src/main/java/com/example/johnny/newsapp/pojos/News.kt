package com.example.johnny.newsapp.pojos

import android.arch.lifecycle.LiveData
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class News(val source: @RawValue NewsSource, val author: String, val title: String, val description: String,
                val url: String, val urlToImage: String, val publishedAt: String): Parcelable

data class NewsSource(val id: String, val name: String)

data class NewsResponse(val status: String, val totalResults: String, val articles: List<News>)