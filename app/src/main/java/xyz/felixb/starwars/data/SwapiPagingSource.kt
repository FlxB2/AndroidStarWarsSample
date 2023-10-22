package xyz.felixb.starwars.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import org.openapitools.client.apis.DefaultApi
import org.openapitools.client.models.Person

class SwapiPagingSource(
    private val api: DefaultApi,
) : PagingSource<Int, Person>(
) {
    override fun getRefreshKey(state: PagingState<Int, Person>) =
        state.anchorPosition?.let { anchorPosition ->
            // This loads starting from previous page, but since PagingConfig.initialLoadSize spans
            // multiple pages, the initial load will still load items centered around
            // anchorPosition. This also prevents needing to immediately launch prepend due to
            // prefetchDistance.
            state.closestPageToPosition(anchorPosition)?.prevKey
        }


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Person> {
        val page = params.key ?: 1

        return try {
            val response = api.peopleGet(page)
            val people = response.body()?.results ?: emptyList()

            LoadResult.Page(
                data = people,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (people.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}