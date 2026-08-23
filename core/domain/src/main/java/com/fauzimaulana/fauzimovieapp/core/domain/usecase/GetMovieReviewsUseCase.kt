package com.fauzimaulana.fauzimovieapp.core.domain.usecase

import androidx.paging.PagingData
import com.fauzimaulana.fauzimovieapp.core.domain.repository.MovieRepository
import com.fauzimaulana.fauzimovieapp.core.model.data.ReviewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieReviewsUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(movieId: Int): Flow<PagingData<ReviewModel>> =
        repository.getMovieReviews(movieId)
}