package com.fauzimaulana.fauzimovieapp.feature.movie.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.fauzimaulana.fauzimovieapp.core.domain.usecase.GetMovieReviewsUseCase
import com.fauzimaulana.fauzimovieapp.core.model.data.ReviewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    getMovieReviewsUseCase: GetMovieReviewsUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val movieId: Int = checkNotNull(savedStateHandle["movie_id"])

    val movieReviews: Flow<PagingData<ReviewModel>> =
        getMovieReviewsUseCase(movieId).cachedIn(viewModelScope)
}
