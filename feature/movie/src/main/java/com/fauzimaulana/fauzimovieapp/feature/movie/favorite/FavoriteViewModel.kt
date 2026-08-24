package com.fauzimaulana.fauzimovieapp.feature.movie.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fauzimaulana.fauzimovieapp.core.domain.usecase.favorite.GetFavoriteMoviesUseCase
import com.fauzimaulana.fauzimovieapp.core.model.data.MovieModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

sealed interface FavoriteUiState {
    data object Loading : FavoriteUiState
    data class Success(val movies: List<MovieModel>) : FavoriteUiState
}

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase
) : ViewModel() {

    val uiState: StateFlow<FavoriteUiState> = getFavoriteMoviesUseCase()
        .map { FavoriteUiState.Success(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = FavoriteUiState.Loading
        )
}
