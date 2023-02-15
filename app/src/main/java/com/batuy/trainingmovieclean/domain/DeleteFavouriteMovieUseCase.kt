package com.batuy.trainingmovieclean.domain

import javax.inject.Inject

class DeleteFavouriteMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    suspend operator fun invoke(id: Int) = repository.deleteFavouriteMovie(id)
}