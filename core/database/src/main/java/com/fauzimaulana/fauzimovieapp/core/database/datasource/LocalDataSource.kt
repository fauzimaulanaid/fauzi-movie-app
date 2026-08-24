package com.fauzimaulana.fauzimovieapp.core.database.datasource

import com.fauzimaulana.fauzimovieapp.core.database.dao.FavoriteMovieDao
import com.fauzimaulana.fauzimovieapp.core.database.mappers.toFavoriteMovieEntity
import com.fauzimaulana.fauzimovieapp.core.database.mappers.toMovieModel
import com.fauzimaulana.fauzimovieapp.core.model.data.MovieModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalDataSource @Inject internal constructor(
    private val favoriteMovieDao: FavoriteMovieDao
) {
    suspend fun insertFavoriteMovie(movie: MovieModel) {
        favoriteMovieDao.insertFavoriteMovie(movie.toFavoriteMovieEntity())
    }

    suspend fun deleteFavoriteMovieById(movieId: Int) {
        favoriteMovieDao.deleteFavoriteMovieById(movieId)
    }

    fun isFavoriteMovie(movieId: Int): Flow<Boolean> {
        return favoriteMovieDao.isFavoriteMovie(movieId)
    }

    fun getFavoriteMovies(): Flow<List<MovieModel>> {
        return favoriteMovieDao.getFavoriteMovies().map { entities ->
            entities.map { it.toMovieModel() }
        }
    }
}
