package com.batuy.trainingmovieclean.domain

class InsertFavouriteMovieUseCase(private val repository: MovieRepository) {

    suspend operator fun invoke(movie: Movie) = repository.insertFavouriteMovie(movie)
}