package com.fauzimaulana.fauzimovieapp.core.network

import androidx.paging.PagingData
import com.fauzimaulana.fauzimovieapp.core.network.paging.createPager
import com.fauzimaulana.fauzimovieapp.core.network.response.MovieResponse
import com.fauzimaulana.fauzimovieapp.core.network.response.ReviewResponse
import com.fauzimaulana.fauzimovieapp.core.network.service.ApiService
import kotlinx.coroutines.flow.Flow

class RemoteDataSource(private val apiService: ApiService) {

    fun getPopularMovie(): Flow<PagingData<MovieResponse>> = createPager { page ->
        apiService.getPopularMovie(page).results.orEmpty()
    }

    fun getTopRatedMovie(): Flow<PagingData<MovieResponse>> = createPager { page ->
        apiService.getTopRatedMovie(page).results.orEmpty()
    }

    fun getNowPlayingMovie(): Flow<PagingData<MovieResponse>> = createPager { page ->
        apiService.getNowPlayingMovie(page).results.orEmpty()
    }

    fun getMovieReviews(movieId: Int): Flow<PagingData<ReviewResponse>> = createPager { page ->
        apiService.getMovieReviews(movieId, page).results.orEmpty()
    }
}