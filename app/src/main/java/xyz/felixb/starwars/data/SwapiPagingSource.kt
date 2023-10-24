package xyz.felixb.starwars.data

import androidx.paging.PagingSource
import androidx.paging.PagingState

/**
 * Allows generic loading of pagination data from the SWAPI Api.
 * @param function The function to call to load the data.
 */
class SwapiPagingSource<T: Any>(
    private val function: suspend (page: Int) -> List<T>
) : PagingSource<Int, T>(
) {
    override fun getRefreshKey(state: PagingState<Int, T>) = state.anchorPosition

    override suspend fun load(
        params: LoadParams<Int>,
    ): LoadResult<Int, T> {
        val page = params.key ?: 1

        return try {
            val result = function(page)

            LoadResult.Page(
                data = result,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (result.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}