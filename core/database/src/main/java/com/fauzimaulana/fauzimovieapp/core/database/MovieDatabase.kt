package com.fauzimaulana.fauzimovieapp.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fauzimaulana.fauzimovieapp.core.database.dao.FavoriteMovieDao
import com.fauzimaulana.fauzimovieapp.core.database.entity.FavoriteMovieEntity

@Database(
    entities = [FavoriteMovieEntity::class],
    version = 1,
    exportSchema = false
)
internal abstract class MovieDatabase : RoomDatabase() {
    abstract fun favoriteMovieDao(): FavoriteMovieDao
}
