package com.batuy.trainingmovieclean.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiFactory {

    companion object {
        private const val BASE_URL = "https://api.kinopoisk.dev/"

        private val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create()).build()

        val apiService: ApiService = retrofit.create(ApiService::class.java)
    }
}