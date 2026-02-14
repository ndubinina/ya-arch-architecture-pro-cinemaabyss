package ru.arch.cinemaabyss.proxy.api.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param error Сообщение об ошибке
 */
data class Error(

    @Schema(example = "Internal Server Error", required = true, description = "Сообщение об ошибке")
    @get:JsonProperty("error", required = true) val error: kotlin.String
) {

}

