package com.fauzimaulana.fauzimovieapp.core.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.fauzimaulana.fauzimovieapp.core.ui.R
import com.fauzimaulana.fauzimovieapp.core.ui.theme.FauziMovieAppTheme

@Composable
fun DefaultImageLoader(
    modifier: Modifier = Modifier,
    image: String,
    contentDescription: String
) {
    AsyncImage(
        model = "https://image.tmdb.org/t/p/w500$image",
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        placeholder = painterResource(R.drawable.ic_placeholder),
        error = painterResource(R.drawable.ic_broken_image),
        modifier = modifier,
    )
}

@Preview
@Composable
private fun DefaultImageLoaderPreview() {
    FauziMovieAppTheme {
        DefaultImageLoader(
            image = "/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
            contentDescription = "Spider-Man: No Way Home"
        )
    }
}