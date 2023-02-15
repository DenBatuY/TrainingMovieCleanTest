package com.batuy.trainingmovieclean.domain

import javax.inject.Inject

class IsLoadingUseCase @Inject constructor(private val repository: MovieRepository) {
    operator fun invoke() = repository.isLoading()
}