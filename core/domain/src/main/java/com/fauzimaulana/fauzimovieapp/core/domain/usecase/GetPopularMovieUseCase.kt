package com.fauzimaulana.fauzimovieapp.core.domain.usecase

import androidx.paging.PagingData
import com.fauzimaulana.fauzimovieapp.core.domain.repository.MovieRepository
import com.fauzimaulana.fauzimovieapp.core.model.data.MovieModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(): Flow<PagingData<MovieModel>> =
        repository.getPopularMovie()
}