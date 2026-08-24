package com.fauzimaulana.fauzimovieapp.feature.movie.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.fauzimaulana.fauzimovieapp.core.domain.usecase.GetMovieReviewsUseCase
import com.fauzimaulana.fauzimovieapp.core.domain.usecase.favorite.DeleteFavoriteMovieUseCase
import com.fauzimaulana.fauzimovieapp.core.domain.usecase.favorite.InsertFavoriteMovieUseCase
import com.fauzimaulana.fauzimovieapp.core.domain.usecase.favorite.IsFavoriteMovieUseCase
import com.fauzimaulana.fauzimovieapp.core.model.data.MovieModel
import com.fauzimaulana.fauzimovieapp.core.model.data.ReviewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    getMovieReviewsUseCase: GetMovieReviewsUseCase,
    private val isFavoriteMovieUseCase: IsFavoriteMovieUseCase,
    private val insertFavoriteMovieUseCase: InsertFavoriteMovieUseCase,
    private val deleteFavoriteMovieUseCase: DeleteFavoriteMovieUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val movieId: Int = checkNotNull(savedStateHandle["movie_id"])

    val movieReviews: Flow<PagingData<ReviewModel>> =
        getMovieReviewsUseCase(movieId).cachedIn(viewModelScope)

    val isFavorite: StateFlow<Boolean> = isFavoriteMovieUseCase(movieId)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false
        )

    fun toggleFavorite(movie: MovieModel) {
        viewModelScope.launch {
            if (isFavorite.value) {
                deleteFavoriteMovieUseCase(movie.id)
            } else {
                insertFavoriteMovieUseCase(movie)
            }
        }
    }
}
