package com.batuy.trainingmovieclean.domain

import javax.inject.Inject

class GetListOfMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    operator fun invoke() = repository.listOfMovie()
}