package com.batuy.trainingmovieclean.domain

import androidx.lifecycle.LiveData

interface MovieRepository {

    suspend fun loadMovies()

    fun listOfMovie(): LiveData<List<Movie>>

    suspend fun insertFavouriteMovie(movie: Movie)

    suspend fun deleteFavouriteMovie(movieId: Int)

    fun listFavouriteMovies(): LiveData<List<Movie>>

    fun favouriteMovie(id: Int): LiveData<Movie>

    fun isLoading():LiveData<Boolean>
}