package com.fauzimaulana.fauzimovieapp.feature.movie.favorite

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fauzimaulana.fauzimovieapp.core.model.data.MovieModel
import com.fauzimaulana.fauzimovieapp.core.ui.components.DefaultToolbar
import com.fauzimaulana.fauzimovieapp.core.ui.theme.FauziMovieAppTheme
import com.fauzimaulana.fauzimovieapp.feature.movie.R
import com.fauzimaulana.fauzimovieapp.feature.movie.favorite.content.FavoriteScreenContent

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    viewModel: FavoriteViewModel = hiltViewModel(),
    onBackPressed: () -> Unit,
    onMovieClicked: (MovieModel) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier,
        topBar = {
            DefaultToolbar(
                title = stringResource(R.string.favorite_movie),
                onBackPressed = onBackPressed
            )
        }
    ) { paddingValues ->
        FavoriteScreenContent(
            modifier = Modifier.padding(paddingValues),
            uiState = uiState,
            onMovieClicked = onMovieClicked
        )
    }
}

@Preview
@Composable
private fun FavoriteScreenPreview() {
    FauziMovieAppTheme {
        FavoriteScreen(
            onBackPressed = {},
            onMovieClicked = {}
        )
    }
}
