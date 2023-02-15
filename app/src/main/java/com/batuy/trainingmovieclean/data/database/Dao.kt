package com.batuy.trainingmovieclean.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao {

    @Query("SELECT*FROM loading_movies")
    fun getAllLoadingMovies(): LiveData<List<MovieDb>>

    @Query("SELECT*FROM loading_movies WHERE id=:movieId")
    fun grtFavouriteMovie(movieId: Int): LiveData<MovieDb>

    @Insert
    suspend fun insertMovie(movie: MovieDb)

    @Query("DELETE FROM loading_movies WHERE id = :movieId")
    suspend fun deleteFavouriteMovie(movieId: Int)
}