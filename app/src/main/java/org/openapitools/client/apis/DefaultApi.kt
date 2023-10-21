package org.openapitools.client.apis

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import org.openapitools.client.models.Film
import org.openapitools.client.models.Person
import org.openapitools.client.models.Planet

interface DefaultApi {
    /**
     * 
     * Get all films.
     * Responses:
     *  - 200: An array of films.
     *
     * @return [kotlin.collections.List<Film>]
     */
    @GET("api/films")
    suspend fun apiFilmsGet(): Response<kotlin.collections.List<Film>>

    /**
     * 
     * Get a specific film by id.
     * Responses:
     *  - 200: A film.
     *
     * @param id Id of the film.
     * @return [kotlin.Any]
     */
    @GET("api/films/{id}")
    suspend fun apiFilmsIdGet(@Path("id") id: kotlin.String): Response<kotlin.Any>

    /**
     * 
     * Get all people.
     * Responses:
     *  - 200: An array of people.
     *
     * @return [kotlin.collections.List<Person>]
     */
    @GET("api/people")
    suspend fun apiPeopleGet(): Response<kotlin.collections.List<Person>>

    /**
     * 
     * Get a specific person by id.
     * Responses:
     *  - 200: A person.
     *
     * @param id Id of the person.
     * @return [kotlin.Any]
     */
    @GET("api/people/{id}")
    suspend fun apiPeopleIdGet(@Path("id") id: kotlin.String): Response<kotlin.Any>

    /**
     * 
     * Get all planets.
     * Responses:
     *  - 200: An array of planets.
     *
     * @return [kotlin.collections.List<Planet>]
     */
    @GET("api/planets")
    suspend fun apiPlanetsGet(): Response<kotlin.collections.List<Planet>>

    /**
     * 
     * Get a specific planet by id.
     * Responses:
     *  - 200: A planet.
     *
     * @param id Id of the planet.
     * @return [kotlin.Any]
     */
    @GET("api/planets/{id}")
    suspend fun apiPlanetsIdGet(@Path("id") id: kotlin.String): Response<kotlin.Any>

}
