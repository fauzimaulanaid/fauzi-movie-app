package com.fauzimaulana.fauzimovieapp.core.network.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(

	@SerializedName("id")
	val id: Int? = null,

	@SerializedName("poster_path")
	val posterPath: String? = null,

	@SerializedName("backdrop_path")
	val backdropPath: String? = null,

	@SerializedName("title")
	val title: String? = null,

	@SerializedName("release_date")
	val releaseDate: String? = null,

	@SerializedName("overview")
	val overview: String? = null,
)
