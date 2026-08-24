package com.fauzimaulana.fauzimovieapp.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fauzimaulana.fauzimovieapp.core.database.entity.FavoriteMovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface FavoriteMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteMovie(movie: FavoriteMovieEntity)

    @Query("DELETE FROM favorite_movie WHERE id = :movieId")
    suspend fun deleteFavoriteMovieById(movieId: Int)

    @Query("SELECT EXISTS(SELECT 1 FROM favorite_movie WHERE id = :movieId)")
    fun isFavoriteMovie(movieId: Int): Flow<Boolean>

    @Query("SELECT * FROM favorite_movie")
    fun getFavoriteMovies(): Flow<List<FavoriteMovieEntity>>
}
