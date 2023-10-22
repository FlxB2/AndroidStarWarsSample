package xyz.felixb.starwars.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.openapitools.client.apis.DefaultApi
import org.openapitools.client.models.Person
import javax.inject.Inject

class SwapiRepository @Inject constructor(
    private val api: DefaultApi
){
    fun getPersons(): Flow<PagingData<Person>> = Pager(
        config = PagingConfig(pageSize = PAGING_SIZE, enablePlaceholders = true),
        pagingSourceFactory = { SwapiPagingSource(api) }
    ).flow

    companion object {
        private const val PAGING_SIZE = 10
    }

}