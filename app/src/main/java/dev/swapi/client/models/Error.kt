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


import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Contextual

/**
 * 
 *
 * @param code 
 * @param message 
 * @param fields 
 */
@Serializable

data class Error (

    @SerialName(value = "code")
    val code: kotlin.Int? = null,

    @SerialName(value = "message")
    val message: kotlin.String? = null,

    @SerialName(value = "fields")
    val fields: kotlin.String? = null

)

