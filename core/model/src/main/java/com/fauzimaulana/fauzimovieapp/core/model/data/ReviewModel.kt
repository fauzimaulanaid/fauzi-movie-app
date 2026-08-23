package com.fauzimaulana.fauzimovieapp.core.model.data

data class ReviewModel(
    val id: String = "",
    val author: String = "",
    val authorDetails: AuthorDetailsModel = AuthorDetailsModel(),
    val content: String = "",
    val createdAt: String = "",
)


data class AuthorDetailsModel(
    val name: String = "",
    val rating: Int = 0,
    val username: String = ""
)