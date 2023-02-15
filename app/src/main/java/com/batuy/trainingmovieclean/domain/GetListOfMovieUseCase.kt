package com.batuy.trainingmovieclean.domain

class GetListOfMovieUseCase(private val repository: MovieRepository) {

    operator fun invoke() = repository.listOfMovie()
}