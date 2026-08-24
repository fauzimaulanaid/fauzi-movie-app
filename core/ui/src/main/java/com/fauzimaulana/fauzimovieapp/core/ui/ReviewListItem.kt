package com.fauzimaulana.fauzimovieapp.core.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fauzimaulana.fauzimovieapp.core.model.data.AuthorDetailsModel
import com.fauzimaulana.fauzimovieapp.core.model.data.ReviewModel
import com.fauzimaulana.fauzimovieapp.core.ui.theme.FauziMovieAppTheme
import com.fauzimaulana.fauzimovieapp.core.ui.utils.formatDate

@Composable
fun ReviewListItem(
    modifier: Modifier = Modifier,
    review: ReviewModel
) {
    Column(
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = review.author,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                imageVector = Icons.TwoTone.Star,
                contentDescription = review.authorDetails.rating.toString(),
                tint = Color.Yellow
            )
            Text(
                text = review.authorDetails.rating.toString(),
                style = MaterialTheme.typography.labelSmall,
            )
            Text(
                text = stringResource(R.string.parentheses_placeholder, review.createdAt.formatDate()),
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = review.content,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ReviewListItemPreview() {
    FauziMovieAppTheme {
        ReviewListItem(
            review = ReviewModel(
                id = "1",
                author = "Muhammad Fauzi Maulana",
                content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                createdAt = "2025-12-15",
                authorDetails = AuthorDetailsModel(
                    name = "Fauzi Maulana",
                    username = "fauzimaulana",
                    rating = 5.0
                )
            )
        )
    }
}