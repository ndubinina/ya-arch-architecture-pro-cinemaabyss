package ru.arch.cinemaabyss.proxy.api.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param title Название фильма
 * @param description Описание фильма
 * @param rating Рейтинг фильма
 * @param genres Жанры фильма
 */
data class MovieInput(

    @Schema(example = "Inception", required = true, description = "Название фильма")
    @get:JsonProperty("title", required = true) val title: kotlin.String,

    @Schema(example = "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.", required = true, description = "Описание фильма")
    @get:JsonProperty("description", required = true) val description: kotlin.String,

    @Schema(example = "8.8", required = true, description = "Рейтинг фильма")
    @get:JsonProperty("rating", required = true) val rating: kotlin.Float,

    @Schema(example = "[\"Sci-Fi\",\"Action\",\"Thriller\"]", description = "Жанры фильма")
    @get:JsonProperty("genres") val genres: kotlin.collections.List<kotlin.String>? = null
) {

}

