package com.batuy.trainingmovieclean.domain

import javax.inject.Inject

class FavouriteMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    operator fun invoke(id: Int) = repository.favouriteMovie(id)
}