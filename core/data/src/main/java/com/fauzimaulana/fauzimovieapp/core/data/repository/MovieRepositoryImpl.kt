package com.fauzimaulana.fauzimovieapp.core.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.fauzimaulana.fauzimovieapp.core.data.mappers.toMovieModel
import com.fauzimaulana.fauzimovieapp.core.data.mappers.toReviewModel
import com.fauzimaulana.fauzimovieapp.core.domain.repository.MovieRepository
import com.fauzimaulana.fauzimovieapp.core.model.data.MovieModel
import com.fauzimaulana.fauzimovieapp.core.model.data.ReviewModel
import com.fauzimaulana.fauzimovieapp.core.network.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): MovieRepository {
    override fun getPopularMovie(): Flow<PagingData<MovieModel>> =
        remoteDataSource.getPopularMovie().map { pagingData ->
            pagingData.map { it.toMovieModel() }
        }

    override fun getTopRatedMovie(): Flow<PagingData<MovieModel>> =
        remoteDataSource.getTopRatedMovie().map { pagingData ->
            pagingData.map { it.toMovieModel() }
        }


    override fun getNowPlayingMovie(): Flow<PagingData<MovieModel>> =
        remoteDataSource.getNowPlayingMovie().map { pagingData ->
            pagingData.map { it.toMovieModel() }
        }


    override fun getMovieReviews(movieId: Int): Flow<PagingData<ReviewModel>> =
        remoteDataSource.getMovieReviews(movieId).map { pagingData ->
            pagingData.map { it.toReviewModel() }
        }
}