package xyz.felixb.starwars.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dev.swapi.client.apis.DefaultApi
import dev.swapi.client.models.Film
import dev.swapi.client.models.Person
import dev.swapi.client.models.Planet
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SwapiRepository @Inject constructor(
    private val api: DefaultApi
) {
    fun getPersons(): Flow<PagingData<Person>> = Pager(
        config = PagingConfig(pageSize = PAGING_SIZE, enablePlaceholders = true)
    ) { SwapiPagingSource { page -> api.peopleGet(page).body()?.results ?: listOf() } }.flow

    fun getFilms(): Flow<PagingData<Film>> = Pager(
        config = PagingConfig(pageSize = PAGING_SIZE, enablePlaceholders = true)
    ) { SwapiPagingSource { page -> api.filmsGet(page).body()?.results ?: listOf() } }.flow

    fun getPlanets(): Flow<PagingData<Planet>> = Pager(
        config = PagingConfig(pageSize = PAGING_SIZE, enablePlaceholders = true)
    ) { SwapiPagingSource { page -> api.planetsGet(page).body()?.results ?: listOf() } }.flow

    companion object {
        private const val PAGING_SIZE = 10
    }

}