package com.fauzimaulana.fauzimovieapp.core.domain.usecase.favorite

import com.fauzimaulana.fauzimovieapp.core.domain.repository.MovieRepository
import com.fauzimaulana.fauzimovieapp.core.model.data.MovieModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoriteMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(): Flow<List<MovieModel>> = repository.getFavoriteMovies()
}
