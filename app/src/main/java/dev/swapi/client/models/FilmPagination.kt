/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package dev.swapi.client.models

import dev.swapi.client.models.Film

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Contextual

/**
 * 
 *
 * @param count Number of items in the response.
 * @param next Link to the next page of items.
 * @param previous Link to the previous page of items.
 * @param results 
 */
@Serializable

data class FilmPagination (

    /* Number of items in the response. */
    @SerialName(value = "count")
    val count: kotlin.Int? = null,

    /* Link to the next page of items. */
    @SerialName(value = "next")
    val next: kotlin.String? = null,

    /* Link to the previous page of items. */
    @SerialName(value = "previous")
    val previous: kotlin.String? = null,

    @SerialName(value = "results")
    val results: kotlin.collections.List<Film>? = null

)

