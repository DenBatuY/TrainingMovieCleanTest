package com.batuy.trainingmovieclean.domain

import android.util.Log
import javax.inject.Inject

class LoadMoviesUseCase @Inject constructor(private val repository: MovieRepository) {

suspend operator fun invoke()=repository.loadMovies()

}