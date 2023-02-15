package com.batuy.trainingmovieclean.domain

class FavouriteMovieUseCase(private val repository: MovieRepository) {

    operator fun invoke(id: Int) = repository.favouriteMovie(id)
}