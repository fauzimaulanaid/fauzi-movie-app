package com.fauzimaulana.fauzimovieapp.core.network.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState

open class BasePagingSource<T : Any>(
    private val pageSize: Int,
    private val refreshKey: Int? = null,
    private val block: suspend (Int) -> List<T>
): PagingSource<Int, T>()  {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        val page = params.key ?: 1
        return try {
            val response = block(page)
            val nextKey = if (response.isEmpty() || response.size < pageSize) null else page + 1
            LoadResult.Page(
                data = response,
                prevKey = null,
                nextKey = nextKey
            )
        } catch (e: Throwable) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        val refKey = refreshKey?.takeIf { it > 0 } ?: state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
        return refKey
    }
}