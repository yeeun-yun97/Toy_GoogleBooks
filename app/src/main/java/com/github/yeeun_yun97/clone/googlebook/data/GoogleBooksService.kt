package com.github.yeeun_yun97.clone.googlebook.data

import com.github.yeeun_yun97.clone.googlebook.data.model.SearchBooks
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleBooksService {
    companion object {
        private lateinit var service: GoogleBooksService
        fun newInstance(): GoogleBooksService {
            if (!this::service.isInitialized) {
                service = Retrofit.Builder()
                    .baseUrl("https://www.googleapis.com/books/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(GoogleBooksService::class.java)
            }
            return service;
        }
    }

    @GET("volumes")
    suspend fun searchBookByName(@Query("q") q: String): Response<SearchBooks>

}