package com.fauzimaulana.fauzimovieapp.core.data.mappers

import com.fauzimaulana.fauzimovieapp.core.model.data.AuthorDetailsModel
import com.fauzimaulana.fauzimovieapp.core.model.data.ReviewModel
import com.fauzimaulana.fauzimovieapp.core.network.response.ReviewResponse

fun ReviewResponse.toReviewModel() = ReviewModel(
    id = id.orEmpty(),
    author = author.orEmpty(),
    content = content.orEmpty(),
    createdAt = createdAt.orEmpty(),
    authorDetails = AuthorDetailsModel(
        name = authorDetails?.name.orEmpty(),
        rating = authorDetails?.rating ?: 0.0,
        username = authorDetails?.username.orEmpty()
    )
)