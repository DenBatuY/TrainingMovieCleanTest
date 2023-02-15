package com.batuy.trainingmovieclean.domain

class DeleteFavouriteMovieUseCase(private val repository: MovieRepository) {

    suspend operator fun invoke(id: Int) = repository.deleteFavouriteMovie(id)
}