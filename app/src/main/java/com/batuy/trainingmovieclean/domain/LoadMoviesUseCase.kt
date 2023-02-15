package com.batuy.trainingmovieclean.domain

import android.util.Log

class LoadMoviesUseCase(private val repository: MovieRepository) {

suspend operator fun invoke()=repository.loadMovies()

}