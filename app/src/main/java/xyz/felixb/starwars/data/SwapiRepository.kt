package xyz.felixb.starwars.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dev.swapi.client.apis.DefaultApi
import dev.swapi.client.models.Person
import kotlinx.coroutines.flow.Flow
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