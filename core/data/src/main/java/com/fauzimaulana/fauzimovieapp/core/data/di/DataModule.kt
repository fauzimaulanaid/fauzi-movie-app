package com.fauzimaulana.fauzimovieapp.core.data.di

import com.fauzimaulana.fauzimovieapp.core.data.repository.MovieRepositoryImpl
import com.fauzimaulana.fauzimovieapp.core.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindRepository(
        movieRepositoryImpl: MovieRepositoryImpl
    ): MovieRepository

}