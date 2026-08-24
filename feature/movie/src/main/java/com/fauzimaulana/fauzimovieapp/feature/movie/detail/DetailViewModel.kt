package com.fauzimaulana.fauzimovieapp.feature.movie.detail

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
    getMovieReviewsUseCase: GetMovieReviewsUseCase
): ViewModel() {
    val movieReviews: Flow<PagingData<ReviewModel>> =
        getMovieReviewsUseCase(969681).cachedIn(viewModelScope)
}