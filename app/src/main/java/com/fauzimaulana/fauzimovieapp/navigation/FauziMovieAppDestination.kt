package com.fauzimaulana.fauzimovieapp.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface FauziMovieAppDestination {
    val route: String
}

object Home: FauziMovieAppDestination {
    override val route: String = "home"
}

object Detail: FauziMovieAppDestination {
    override val route: String = "detail"

    const val MOVIE_ID = "movie_id"
    const val MOVIE_TITLE = "movie_title"
    const val MOVIE_BACKDROP = "movie_backdrop"
    const val MOVIE_POSTER = "movie_poster"
    const val RELEASE_DATE = "release_date"
    const val OVERVIEW = "overview"

    val routeWithArgs = "$route/{$MOVIE_ID}/{$MOVIE_TITLE}/{$MOVIE_BACKDROP}/{$MOVIE_POSTER}/{$RELEASE_DATE}/{$OVERVIEW}"

    val arguments = listOf(
        navArgument(MOVIE_ID) { type = NavType.IntType },
        navArgument(MOVIE_TITLE) { type = NavType.StringType },
        navArgument(MOVIE_BACKDROP) { type = NavType.StringType },
        navArgument(MOVIE_POSTER) { type = NavType.StringType },
        navArgument(RELEASE_DATE) { type = NavType.StringType },
        navArgument(OVERVIEW) { type = NavType.StringType }
    )
}

object Favorite: FauziMovieAppDestination {
    override val route: String = "favorite"
}