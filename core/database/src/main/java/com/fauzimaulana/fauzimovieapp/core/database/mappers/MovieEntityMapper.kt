package com.fauzimaulana.fauzimovieapp.core.database.mappers

import com.fauzimaulana.fauzimovieapp.core.database.entity.FavoriteMovieEntity
import com.fauzimaulana.fauzimovieapp.core.model.data.MovieModel

internal fun MovieModel.toFavoriteMovieEntity() = FavoriteMovieEntity(
    id = id,
    posterPath = posterPath,
    backdropPath = backdropPath,
    title = title,
    releaseDate = releaseDate,
    overview = overview
)

internal fun FavoriteMovieEntity.toMovieModel() = MovieModel(
    id = id,
    posterPath = posterPath,
    backdropPath = backdropPath,
    title = title,
    releaseDate = releaseDate,
    overview = overview
)
