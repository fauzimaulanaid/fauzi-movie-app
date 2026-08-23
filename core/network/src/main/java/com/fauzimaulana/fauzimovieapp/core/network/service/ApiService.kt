package com.fauzimaulana.fauzimovieapp.core.network.service

import com.fauzimaulana.fauzimovieapp.core.network.response.BaseResponse
import com.fauzimaulana.fauzimovieapp.core.network.response.MovieResponse
import com.fauzimaulana.fauzimovieapp.core.network.response.ReviewResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    suspend fun getPopularMovie(
        @Query("page") page: Int
    ): BaseResponse<List<MovieResponse>>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovie(
        @Query("page") page: Int
    ): BaseResponse<List<MovieResponse>>

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovie(
        @Query("page") page: Int
    ): BaseResponse<List<MovieResponse>>

    @GET("movie/{movie_id}/reviews")
    suspend fun getMovieReviews(
        @Path("movie_id") movieId: Int,
        @Query("page") page: Int
    ): BaseResponse<List<ReviewResponse>>
}