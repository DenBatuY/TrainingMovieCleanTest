package com.batuy.trainingmovieclean.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.batuy.trainingmovieclean.data.repository.MovieRepositoryImpl
import com.batuy.trainingmovieclean.domain.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val loadUseCase: LoadMoviesUseCase,
    private val listOfMoviesUseCase: GetListOfMovieUseCase,
    private val insertFavouriteMovieUseCase: InsertFavouriteMovieUseCase,
    private val deleteFavouriteMovieUseCase: DeleteFavouriteMovieUseCase,
    private val listFavouriteMoviesUseCase: ListFavouriteMoviesUseCase,
    private val favouriteMovieUseCase: FavouriteMovieUseCase,
    private val isLoadingUseCase: IsLoadingUseCase
) : ViewModel() {




    fun loadMovies() {
        viewModelScope.launch {
            //Log.d("test","MainViewModel  loadMovies")
            loadUseCase()
        }
    }

    val listOfMovie = listOfMoviesUseCase()

    val isLoading = isLoadingUseCase()

    fun insertFavouriteMovie(movie: Movie) {
        viewModelScope.launch {
            insertFavouriteMovieUseCase(movie)
        }
    }

    fun deleteFavouriteMovie(id: Int) {
        viewModelScope.launch {
            deleteFavouriteMovieUseCase(id)
        }
    }

    val listFavouriteMovies = listFavouriteMoviesUseCase()

    fun favouriteMovie(id: Int) = favouriteMovieUseCase(id)

}