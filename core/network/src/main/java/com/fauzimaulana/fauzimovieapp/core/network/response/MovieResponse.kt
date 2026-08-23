package com.fauzimaulana.fauzimovieapp.core.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(

	@SerialName("id")
	val id: Int? = null,

	@SerialName("poster_path")
	val posterPath: String? = null,

	@SerialName("backdrop_path")
	val backdropPath: String? = null,

	@SerialName("title")
	val title: String? = null,

	@SerialName("release_date")
	val releaseDate: String? = null,

	@SerialName("overview")
	val overview: String? = null,
)
