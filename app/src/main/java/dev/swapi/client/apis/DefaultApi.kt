package dev.swapi.client.apis

import dev.swapi.client.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.swapi.client.models.FilmPagination
import dev.swapi.client.models.PersonPagination
import dev.swapi.client.models.PlanetPagination

interface DefaultApi {
    /**
     * 
     * Get all films.
     * Responses:
     *  - 200: An array of films.
     *
     * @param page Numeric ID of the page to get
     * @return [kotlin.collections.List<FilmPagination>]
     */
    @GET("films")
    suspend fun filmsGet(@Query("page") page: kotlin.Int): Response<kotlin.collections.List<FilmPagination>>

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
     * @param page Numeric ID of the page to get
     * @return [PersonPagination]
     */
    @GET("people")
    suspend fun peopleGet(@Query("page") page: kotlin.Int): Response<PersonPagination>

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
     * @param page Numeric ID of the page to get
     * @return [kotlin.collections.List<PlanetPagination>]
     */
    @GET("planets")
    suspend fun planetsGet(@Query("page") page: kotlin.Int): Response<kotlin.collections.List<PlanetPagination>>

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
