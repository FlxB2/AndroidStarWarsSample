package org.openapitools.client.apis

import org.openapitools.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import org.openapitools.client.models.Film
import org.openapitools.client.models.PaginationPerson
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
    @GET("films")
    suspend fun filmsGet(): Response<kotlin.collections.List<Film>>

    /**
     * 
     * Get a specific film by id.
     * Responses:
     *  - 200: A film.
     *
     * @param id Id of the film.
     * @return [kotlin.Any]
     */
    @GET("films/{id}")
    suspend fun filmsIdGet(@Path("id") id: kotlin.String): Response<kotlin.Any>

    /**
     * 
     * Get all people.
     * Responses:
     *  - 200: An array of people.
     *
     * @return [PaginationPerson]
     */
    @GET("people")
    suspend fun peopleGet(): Response<PaginationPerson>

    /**
     * 
     * Get a specific person by id.
     * Responses:
     *  - 200: A person.
     *
     * @param id Id of the person.
     * @return [kotlin.Any]
     */
    @GET("people/{id}")
    suspend fun peopleIdGet(@Path("id") id: kotlin.String): Response<kotlin.Any>

    /**
     * 
     * Get all planets.
     * Responses:
     *  - 200: An array of planets.
     *
     * @return [kotlin.collections.List<Planet>]
     */
    @GET("planets")
    suspend fun planetsGet(): Response<kotlin.collections.List<Planet>>

    /**
     * 
     * Get a specific planet by id.
     * Responses:
     *  - 200: A planet.
     *
     * @param id Id of the planet.
     * @return [kotlin.Any]
     */
    @GET("planets/{id}")
    suspend fun planetsIdGet(@Path("id") id: kotlin.String): Response<kotlin.Any>

}
