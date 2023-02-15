package com.batuy.trainingmovieclean.domain

import javax.inject.Inject

class InsertFavouriteMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    suspend operator fun invoke(movie: Movie) = repository.insertFavouriteMovie(movie)
}