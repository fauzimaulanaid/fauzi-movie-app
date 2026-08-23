package com.fauzimaulana.fauzimovieapp.core.network.response

import com.google.gson.annotations.SerializedName

open class BaseResponse<T> {

    @SerializedName("results")
    val results: T? = null
}
