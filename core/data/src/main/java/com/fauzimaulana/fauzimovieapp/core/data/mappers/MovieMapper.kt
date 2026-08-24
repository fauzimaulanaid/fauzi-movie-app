package com.fauzimaulana.fauzimovieapp.core.data.mappers

import com.fauzimaulana.fauzimovieapp.core.model.data.MovieModel
import com.fauzimaulana.fauzimovieapp.core.network.response.MovieResponse

fun MovieResponse.toMovieModel() = MovieModel(
    id = id ?: 0,
    posterPath = posterPath.orEmpty(),
    backdropPath = backdropPath.orEmpty(),
    title = title.orEmpty(),
    releaseDate = releaseDate.orEmpty(),
    overview = overview.orEmpty()
)