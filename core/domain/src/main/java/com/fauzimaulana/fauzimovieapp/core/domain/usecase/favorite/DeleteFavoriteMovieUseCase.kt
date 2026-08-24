package com.fauzimaulana.fauzimovieapp.core.domain.usecase.favorite

import com.fauzimaulana.fauzimovieapp.core.domain.repository.MovieRepository
import javax.inject.Inject

class DeleteFavoriteMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(movieId: Int) = repository.deleteFavoriteMovieById(movieId)
}
