package ru.arch.cinemaabyss.proxy.api.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param status 
 */
data class GetMoviesServiceHealth200Response(

    @Schema(example = "true", description = "")
    @get:JsonProperty("status") val status: kotlin.Boolean? = null
) {

}

