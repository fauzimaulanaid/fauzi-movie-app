package com.fauzimaulana.fauzimovieapp.feature.movie.favorite.content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fauzimaulana.fauzimovieapp.core.model.data.MovieModel
import com.fauzimaulana.fauzimovieapp.core.ui.listitem.FavoriteMovieListItem
import com.fauzimaulana.fauzimovieapp.core.ui.theme.FauziMovieAppTheme
import com.fauzimaulana.fauzimovieapp.feature.movie.R
import com.fauzimaulana.fauzimovieapp.feature.movie.favorite.FavoriteUiState
import com.fauzimaulana.fauzimovieapp.feature.movie.preview.previewMovieList

@Composable
fun FavoriteScreenContent(
    modifier: Modifier = Modifier,
    uiState: FavoriteUiState,
    onMovieClicked: (MovieModel) -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (uiState) {
            is FavoriteUiState.Loading -> {
                CircularProgressIndicator()
            }

            is FavoriteUiState.Success -> {
                if (uiState.movies.isEmpty()) {
                    Text(
                        text = stringResource(R.string.no_favorite_movie),
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp)
                    ) {
                        items(
                            items = uiState.movies,
                            key = { it.id }
                        ) { movie ->
                            FavoriteMovieListItem(
                                movie = movie,
                                onClick = onMovieClicked
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FavoriteScreenContentPreview() {
    FauziMovieAppTheme {
        FavoriteScreenContent(
            uiState = FavoriteUiState.Success(previewMovieList),
            onMovieClicked = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FavoriteScreenContentEmptyPreview() {
    FauziMovieAppTheme {
        FavoriteScreenContent(
            uiState = FavoriteUiState.Success(emptyList()),
            onMovieClicked = {}
        )
    }
}
