package com.batuy.trainingmovieclean.domain

class IsLoadingUseCase(private val repository: MovieRepository) {
    operator fun invoke()=repository.isLoading()
}