package com.fauzimaulana.fauzimovieapp.core.domain.repository

import androidx.paging.PagingData
import com.fauzimaulana.fauzimovieapp.core.model.data.MovieModel
import com.fauzimaulana.fauzimovieapp.core.model.data.ReviewModel
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getPopularMovie(): Flow<PagingData<MovieModel>>

    fun getTopRatedMovie(): Flow<PagingData<MovieModel>>

    fun getNowPlayingMovie(): Flow<PagingData<MovieModel>>

    fun getMovieReviews(movieId: Int): Flow<PagingData<ReviewModel>>
}