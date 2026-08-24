package com.fauzimaulana.fauzimovieapp.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_movie")
internal data class FavoriteMovieEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "poster_path")
    val posterPath: String,
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String,
    val title: String,
    @ColumnInfo(name = "release_date")
    val releaseDate: String,
    val overview: String
)
