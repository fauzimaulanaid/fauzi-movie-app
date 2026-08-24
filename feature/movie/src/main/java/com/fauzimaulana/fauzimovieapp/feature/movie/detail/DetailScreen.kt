package com.fauzimaulana.fauzimovieapp.feature.movie.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.fauzimaulana.fauzimovieapp.core.model.data.MovieModel
import com.fauzimaulana.fauzimovieapp.core.ui.components.DefaultIconButton
import com.fauzimaulana.fauzimovieapp.core.ui.components.DefaultToolbar
import com.fauzimaulana.fauzimovieapp.core.ui.theme.FauziMovieAppTheme
import com.fauzimaulana.fauzimovieapp.feature.movie.R
import com.fauzimaulana.fauzimovieapp.feature.movie.detail.content.DetailScreenContent

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    movie: MovieModel,
    onBackPressed: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            DefaultToolbar(
                title = stringResource(R.string.detail),
                containerColor = Color.Transparent,
                onBackPressed = onBackPressed
            )
        },
        content = { paddingValues ->
            DetailScreenContent(
                modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding()),
                movie = movie
            )
        },
        bottomBar = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    DefaultIconButton(
                        icon = Icons.Filled.Favorite,
                        contentDescription = stringResource(R.string.favorite),
                        contentColor = Color.Black,
                        onClick = {}
                    )
                    DefaultIconButton(
                        icon = Icons.Filled.Share,
                        contentDescription = stringResource(R.string.share),
                        contentColor = Color.Black,
                        onClick = {}
                    )
                }
            }
        }
    )
}

@Preview
@Composable
private fun DetailScreenPreview() {
    FauziMovieAppTheme {
        DetailScreen(
            movie = MovieModel(
                id = 1,
                title = "Spider-Man: No Way Home",
                releaseDate = "2025-12-15",
                overview = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                posterPath = "https://image.tmdb.org/t/p/w500/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
                backdropPath = "https://image.tmdb.org/t/p/original/7iwUUcKURMT7aKfCwMy6YnGtchD.jpg"
            ),
            onBackPressed = {}
        )
    }
}