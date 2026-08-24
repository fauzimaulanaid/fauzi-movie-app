package com.fauzimaulana.fauzimovieapp.feature.movie.detail.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fauzimaulana.fauzimovieapp.core.model.data.MovieModel
import com.fauzimaulana.fauzimovieapp.core.ui.components.DefaultImageLoader
import com.fauzimaulana.fauzimovieapp.core.ui.components.SectionTitle
import com.fauzimaulana.fauzimovieapp.core.ui.theme.FauziMovieAppTheme
import com.fauzimaulana.fauzimovieapp.core.ui.utils.formatDate
import com.fauzimaulana.fauzimovieapp.feature.movie.R

@Composable
fun DetailScreenContent(
    modifier: Modifier = Modifier,
    movie: MovieModel
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        DefaultImageLoader(
            image = movie.backdropPath,
            contentDescription = movie.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        SectionTitle(
            title = movie.title
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = movie.releaseDate.formatDate(),
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        SectionTitle(
            title = stringResource(R.string.description)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = movie.overview,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        SectionTitle(
            title = stringResource(R.string.review)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DetailScreenContentPreview() {
    FauziMovieAppTheme {
        DetailScreenContent(
            movie = MovieModel(
                id = 1,
                title = "Spider-Man: No Way Home",
                releaseDate = "2025-12-15",
                overview = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                posterPath = "https://image.tmdb.org/t/p/w500/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
                backdropPath = "https://image.tmdb.org/t/p/w500/7iwUUcKURMT7aKfCwMy6YnGtchD.jpg"
            )
        )
    }
}