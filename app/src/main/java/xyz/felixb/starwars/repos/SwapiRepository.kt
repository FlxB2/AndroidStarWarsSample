package xyz.felixb.starwars.repos

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.openapitools.client.apis.DefaultApi
import org.openapitools.client.models.Person
import javax.inject.Inject

class SwapiRepository @Inject constructor(
    private val api: DefaultApi
){
    fun getPersons(): Flow<List<Person>> = flow {
        emit( api.peopleGet().body()?.results?: listOf())
    }

}