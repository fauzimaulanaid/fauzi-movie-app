package com.fauzimaulana.fauzimovieapp.core.database.di

import android.content.Context
import androidx.room.Room
import com.fauzimaulana.fauzimovieapp.core.database.MovieDatabase
import com.fauzimaulana.fauzimovieapp.core.database.dao.FavoriteMovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MovieDatabase {
        return Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            "movie.db"
        ).build()
    }

    @Provides
    internal fun provideFavoriteMovieDao(database: MovieDatabase): FavoriteMovieDao {
        return database.favoriteMovieDao()
    }
}
