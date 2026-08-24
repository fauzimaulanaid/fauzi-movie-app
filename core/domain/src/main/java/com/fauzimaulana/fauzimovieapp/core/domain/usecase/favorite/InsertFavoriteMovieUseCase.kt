package com.fauzimaulana.fauzimovieapp.core.domain.usecase.favorite

import com.fauzimaulana.fauzimovieapp.core.domain.repository.MovieRepository
import com.fauzimaulana.fauzimovieapp.core.model.data.MovieModel
import javax.inject.Inject

class InsertFavoriteMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(movie: MovieModel) = repository.insertFavoriteMovie(movie)
}
