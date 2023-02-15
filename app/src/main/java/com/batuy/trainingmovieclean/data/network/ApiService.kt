package com.batuy.trainingmovieclean.data.network

import com.batuy.trainingmovieclean.data.network.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("movie?")
    suspend fun loadMovies(
        @Query("page") page: Int,
        @Query("token") token: String = TOKEN,
        @Query("field") ratingKp: String = "rating.kp",
        @Query("search") rating: String = "7-8",
        @Query("limit") limit: Int = 30,
        @Query("sortType") sortedType: String = "-1",
        @Query("sortField") sortedField: String = "votes.imdb",

    ): MovieResponse


    companion object {
        private const val TOKEN = "W8PXT8E-C58MCCK-Q8W6M74-JFM3XRC"
    }
}