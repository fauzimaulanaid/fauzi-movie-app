package com.fauzimaulana.fauzimovieapp.core.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    @SerialName("results")
    val results: T? = null
)
