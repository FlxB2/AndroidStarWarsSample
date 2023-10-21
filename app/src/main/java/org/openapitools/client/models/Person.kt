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

package org.openapitools.client.models


import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Contextual

/**
 * 
 *
 * @param id Unique identifier representing a specific person for a given character persona.
 * @param name Display name of person.
 * @param homeWorldId Indetifier of the planet the person is from.
 * @param allegiance Which side or team the person has an allegiance.
 */
@Serializable

data class Person (

    /* Unique identifier representing a specific person for a given character persona. */
    @Contextual @SerialName(value = "id")
    val id: java.math.BigDecimal? = null,

    /* Display name of person. */
    @SerialName(value = "name")
    val name: kotlin.String? = null,

    /* Indetifier of the planet the person is from. */
    @SerialName(value = "homeWorldId")
    val homeWorldId: kotlin.Int? = null,

    /* Which side or team the person has an allegiance. */
    @SerialName(value = "allegiance")
    val allegiance: kotlin.String? = null

)

