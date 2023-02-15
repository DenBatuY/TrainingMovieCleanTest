package com.batuy.trainingmovieclean.domain

class ListFavouriteMoviesUseCase(private val repository: MovieRepository) {

    operator fun invoke() = repository.listFavouriteMovies()
}