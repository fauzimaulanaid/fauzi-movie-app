package com.fauzimaulana.fauzimovieapp.core.network.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

internal fun <T: Any> createPager(
    pageSize: Int = DEFAULT_PAGE_SIZE,
    enablePlaceholders: Boolean = false,
    block: suspend (Int) -> List<T>
): Flow<PagingData<T>> = Pager(
    config = PagingConfig(
        pageSize = pageSize,
        enablePlaceholders = enablePlaceholders
    ),
    pagingSourceFactory = {
        BasePagingSource(
            pageSize = pageSize,
            block = block
        )
    }
).flow

private const val DEFAULT_PAGE_SIZE = 20