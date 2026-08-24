package com.fauzimaulana.fauzimovieapp.feature.movie.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.fauzimaulana.fauzimovieapp.core.model.data.MovieModel
import com.fauzimaulana.fauzimovieapp.core.ui.components.DefaultIconButton
import com.fauzimaulana.fauzimovieapp.core.ui.components.DefaultToolbar
import com.fauzimaulana.fauzimovieapp.core.ui.theme.FauziMovieAppTheme
import com.fauzimaulana.fauzimovieapp.feature.movie.R
import com.fauzimaulana.fauzimovieapp.feature.movie.home.content.HomeScreenContent

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
    onFavoriteClicked: () -> Unit,
    onMovieClicked: (MovieModel) -> Unit
) {

    val popularMovies = homeViewModel.popularMovie.collectAsLazyPagingItems()
    val topRatedMovies = homeViewModel.topRatedMovie.collectAsLazyPagingItems()
    val nowPlayingMovies = homeViewModel.nowPlayingMovie.collectAsLazyPagingItems()

    Scaffold(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            DefaultToolbar(
                title = stringResource(R.string.app_name),
                actions = {
                    DefaultIconButton(
                        icon = Icons.Filled.Favorite,
                        contentDescription = stringResource(R.string.favorite),
                        onClick = onFavoriteClicked
                    )
                }
            )
        },
        content = { paddingValues ->
            HomeScreenContent(
                modifier = Modifier.padding(paddingValues),
                popularMovies = popularMovies,
                topRatedMovies = topRatedMovies,
                nowPlayingMovies = nowPlayingMovies,
                onMovieClicked = onMovieClicked
            )
        }
    )
}

@Preview
@Composable
private fun HomeScreenPreview() {
    FauziMovieAppTheme {
        HomeScreen(
            onFavoriteClicked = {},
            onMovieClicked = {}
        )
    }
}