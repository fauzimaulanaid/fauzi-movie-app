package com.fauzimaulana.fauzimovieapp.core.domain.usecase.favorite

import com.fauzimaulana.fauzimovieapp.core.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IsFavoriteMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(movieId: Int): Flow<Boolean> = repository.isFavoriteMovie(movieId)
}
