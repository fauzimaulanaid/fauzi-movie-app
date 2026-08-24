package com.fauzimaulana.fauzimovieapp.feature.movie.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.fauzimaulana.fauzimovieapp.core.domain.usecase.GetNowPlayingMovieUseCase
import com.fauzimaulana.fauzimovieapp.core.domain.usecase.GetPopularMovieUseCase
import com.fauzimaulana.fauzimovieapp.core.domain.usecase.GetTopRatedMovieUseCase
import com.fauzimaulana.fauzimovieapp.core.model.data.MovieModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getPopularMovieUseCase: GetPopularMovieUseCase,
    getTopRatedMovieUseCase: GetTopRatedMovieUseCase,
    getNowPlayingMovieUseCase: GetNowPlayingMovieUseCase
): ViewModel() {

    val popularMovie: Flow<PagingData<MovieModel>> =
        getPopularMovieUseCase().cachedIn(viewModelScope)

    val topRatedMovie: Flow<PagingData<MovieModel>> =
        getTopRatedMovieUseCase().cachedIn(viewModelScope)

    val nowPlayingMovie: Flow<PagingData<MovieModel>> =
        getNowPlayingMovieUseCase().cachedIn(viewModelScope)

}