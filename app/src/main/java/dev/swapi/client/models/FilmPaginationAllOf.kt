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
 * @param results 
 */
@Serializable

data class FilmPaginationAllOf (

    @SerialName(value = "results")
    val results: kotlin.collections.List<Film>? = null

)

