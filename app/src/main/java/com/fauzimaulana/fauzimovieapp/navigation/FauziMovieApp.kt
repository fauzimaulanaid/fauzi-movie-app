package com.fauzimaulana.fauzimovieapp.navigation

import android.net.Uri
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fauzimaulana.fauzimovieapp.core.model.data.MovieModel
import com.fauzimaulana.fauzimovieapp.core.ui.theme.FauziMovieAppTheme
import com.fauzimaulana.fauzimovieapp.feature.movie.detail.DetailScreen
import com.fauzimaulana.fauzimovieapp.feature.movie.home.HomeScreen

@Composable
fun FauziMovieApp(
    navController: NavHostController = rememberNavController()
) {
    FauziMovieAppTheme {
        Scaffold { paddingValues ->
            FauziMovieAppNavHost(
                modifier = Modifier.padding(paddingValues),
                navController = navController
            )
        }
    }
}

@Composable
fun FauziMovieAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Home.route,
        modifier = modifier,
    ) {
        composable(route = Home.route) {
            HomeScreen(
                onFavoriteClicked = {
                    navController.navigate(Favorite.route)
                },
                onMovieClicked = { movie ->
                    navController.navigate(
                        Detail.route +
                                "/${movie.id}" +
                                "/${movie.title}" +
                                "/${Uri.encode(movie.backdropPath)}" +
                                "/${Uri.encode(movie.posterPath)}" +
                                "/${Uri.encode(movie.releaseDate)}" +
                                "/${Uri.encode(movie.overview)}"
                    )
                }
            )
        }
        composable(
            route = Detail.routeWithArgs,
            arguments = Detail.arguments
        ) {
            val movieId = it.arguments?.getInt(Detail.MOVIE_ID) ?: 0
            val movieTitle = it.arguments?.getString(Detail.MOVIE_TITLE).orEmpty()
            val movieBackdrop = it.arguments?.getString(Detail.MOVIE_BACKDROP).orEmpty()
            val moviePoster = it.arguments?.getString(Detail.MOVIE_POSTER).orEmpty()
            val releaseDate = it.arguments?.getString(Detail.RELEASE_DATE).orEmpty()
            val overview = it.arguments?.getString(Detail.OVERVIEW).orEmpty()

            DetailScreen(
                movie = MovieModel(
                    id = movieId,
                    title = movieTitle,
                    releaseDate = releaseDate,
                    overview = overview,
                    posterPath = moviePoster,
                    backdropPath = movieBackdrop
                ),
                onBackPressed = {
                    navController.navigateUp()
                }
            )
        }
        composable(route = Favorite.route) {

        }
    }
}