package com.fauzimaulana.fauzimovieapp.core.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.fauzimaulana.fauzimovieapp.core.data.mappers.toMovieModel
import com.fauzimaulana.fauzimovieapp.core.data.mappers.toReviewModel
import com.fauzimaulana.fauzimovieapp.core.database.datasource.LocalDataSource
import com.fauzimaulana.fauzimovieapp.core.domain.repository.MovieRepository
import com.fauzimaulana.fauzimovieapp.core.model.data.MovieModel
import com.fauzimaulana.fauzimovieapp.core.model.data.ReviewModel
import com.fauzimaulana.fauzimovieapp.core.network.datasource.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
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

    override suspend fun insertFavoriteMovie(movie: MovieModel) {
        localDataSource.insertFavoriteMovie(movie)
    }

    override suspend fun deleteFavoriteMovieById(movieId: Int) {
        localDataSource.deleteFavoriteMovieById(movieId)
    }

    override fun isFavoriteMovie(movieId: Int): Flow<Boolean> {
        return localDataSource.isFavoriteMovie(movieId)
    }

    override fun getFavoriteMovies(): Flow<List<MovieModel>> {
        return localDataSource.getFavoriteMovies()
    }
}
