package com.fauzimaulana.fauzimovieapp.feature.movie.home.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.fauzimaulana.fauzimovieapp.core.model.data.MovieModel
import com.fauzimaulana.fauzimovieapp.core.ui.BannerListItem
import com.fauzimaulana.fauzimovieapp.core.ui.MovieListItem
import com.fauzimaulana.fauzimovieapp.core.ui.components.SectionTitle
import com.fauzimaulana.fauzimovieapp.core.ui.theme.FauziMovieAppTheme
import com.fauzimaulana.fauzimovieapp.feature.movie.R
import com.fauzimaulana.fauzimovieapp.feature.movie.preview.previewMovieList
import kotlinx.coroutines.flow.flowOf

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    popularMovies: LazyPagingItems<MovieModel>,
    topRatedMovies: LazyPagingItems<MovieModel>,
    nowPlayingMovies: LazyPagingItems<MovieModel>
) {
    Column(
        modifier = modifier
            .padding(top = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        SectionTitle(
            title = stringResource(R.string.popular_movie)
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(count = popularMovies.itemCount) { index ->
                val popularMovie = popularMovies[index] ?: MovieModel()
                BannerListItem(movie = popularMovie)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        SectionTitle(
            title = stringResource(R.string.top_rated)
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(count = topRatedMovies.itemCount) { index ->
                val topRatedMovie = topRatedMovies[index] ?: MovieModel()
                MovieListItem(movie = topRatedMovie)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        SectionTitle(
            title = stringResource(R.string.now_playing)
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(count = nowPlayingMovies.itemCount) { index ->
                val nowPlayingMovie = nowPlayingMovies[index] ?: MovieModel()
                MovieListItem(movie = nowPlayingMovie)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenContentPreview() {
    val fakePagingData = PagingData.from(previewMovieList)
    val fakeFlow = flowOf(fakePagingData)
    FauziMovieAppTheme {
        HomeScreenContent(
            popularMovies = fakeFlow.collectAsLazyPagingItems(),
            topRatedMovies = fakeFlow.collectAsLazyPagingItems(),
            nowPlayingMovies = fakeFlow.collectAsLazyPagingItems()
        )
    }
}