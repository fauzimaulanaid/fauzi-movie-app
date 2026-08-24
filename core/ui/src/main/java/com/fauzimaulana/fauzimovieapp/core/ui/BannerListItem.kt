package com.fauzimaulana.fauzimovieapp.core.ui

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.fauzimaulana.fauzimovieapp.core.model.data.MovieModel
import com.fauzimaulana.fauzimovieapp.core.ui.theme.FauziMovieAppTheme

@Composable
fun BannerListItem(
    modifier: Modifier = Modifier,
    movie: MovieModel
) {
    AsyncImage(
        model = "https://image.tmdb.org/t/p/w500${movie.backdropPath}",
        contentDescription = movie.title,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .width(320.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(8.dp)),
    )
}

@Preview(showBackground = true)
@Composable
private fun BannerListItemPreview() {
    FauziMovieAppTheme {
        BannerListItem(
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