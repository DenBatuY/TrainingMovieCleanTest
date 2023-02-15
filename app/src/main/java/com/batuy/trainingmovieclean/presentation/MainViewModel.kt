package com.batuy.trainingmovieclean.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.batuy.trainingmovieclean.data.repository.MovieRepositoryImpl
import com.batuy.trainingmovieclean.domain.*
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MovieRepositoryImpl(application)
    private val loadUseCase = LoadMoviesUseCase(repository)
    private val listOfMoviesUseCase = GetListOfMovieUseCase(repository)
    private val insertFavouriteMovieUseCase = InsertFavouriteMovieUseCase(repository)
    private val deleteFavouriteMovieUseCase = DeleteFavouriteMovieUseCase(repository)
    private val listFavouriteMoviesUseCase = ListFavouriteMoviesUseCase(repository)
    private val favouriteMovieUseCase = FavouriteMovieUseCase(repository)
    private val isLoadingUseCase = IsLoadingUseCase(repository)


    val listOfMovie = listOfMoviesUseCase()

    val isLoading = isLoadingUseCase()

    fun loadMovies() {
        viewModelScope.launch {
            loadUseCase()
        }
    }

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