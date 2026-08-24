package com.fauzimaulana.fauzimovieapp.feature.movie.detail

import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.fauzimaulana.fauzimovieapp.core.model.data.MovieModel
import com.fauzimaulana.fauzimovieapp.core.ui.components.DefaultIconButton
import com.fauzimaulana.fauzimovieapp.core.ui.components.DefaultToolbar
import com.fauzimaulana.fauzimovieapp.core.ui.theme.FauziMovieAppTheme
import com.fauzimaulana.fauzimovieapp.core.ui.utils.formatDate
import com.fauzimaulana.fauzimovieapp.feature.movie.R
import com.fauzimaulana.fauzimovieapp.feature.movie.detail.content.DetailScreenContent

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    detailViewModel: DetailViewModel = hiltViewModel(),
    movie: MovieModel,
    onBackPressed: () -> Unit
) {
    val movieReviews = detailViewModel.movieReviews.collectAsLazyPagingItems()
    val context = LocalContext.current
    val shareText = stringResource(
        R.string.share_text,
        movie.title,
        movie.releaseDate.formatDate(),
        movie.overview
    )

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
                movie = movie,
                movieReviews = movieReviews
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
                        contentColor = MaterialTheme.colorScheme.primary,
                        onClick = {}
                    )
                    DefaultIconButton(
                        icon = Icons.Filled.Share,
                        contentDescription = stringResource(R.string.share),
                        contentColor = MaterialTheme.colorScheme.primary,
                        onClick = {
                            val intent = Intent(Intent.ACTION_SEND).apply {
                                type = "text/plain"
                                putExtra(Intent.EXTRA_TEXT, shareText)
                            }
                            context.startActivity(Intent.createChooser(intent, null))
                        }
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