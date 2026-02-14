package ru.arch.cinemaabyss.proxy.api.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param movieId Идентификатор фильма
 * @param title Название фильма
 * @param action Действие с фильмом
 * @param userId Идентификатор пользователя (опционально)
 * @param rating Рейтинг (опционально)
 * @param genres Жанры фильма (опционально)
 * @param description Описание фильма (опционально)
 */
data class MovieEvent(

    @Schema(example = "1", required = true, description = "Идентификатор фильма")
    @get:JsonProperty("movie_id", required = true) val movieId: kotlin.Int,

    @Schema(example = "Inception", required = true, description = "Название фильма")
    @get:JsonProperty("title", required = true) val title: kotlin.String,

    @Schema(example = "viewed", required = true, description = "Действие с фильмом")
    @get:JsonProperty("action", required = true) val action: kotlin.String,

    @Schema(example = "1", description = "Идентификатор пользователя (опционально)")
    @get:JsonProperty("user_id") val userId: kotlin.Int? = null,

    @Schema(example = "8.5", description = "Рейтинг (опционально)")
    @get:JsonProperty("rating") val rating: kotlin.Float? = null,

    @Schema(example = "[\"Sci-Fi\",\"Action\"]", description = "Жанры фильма (опционально)")
    @get:JsonProperty("genres") val genres: kotlin.collections.List<kotlin.String>? = null,

    @Schema(example = "A mind-bending thriller", description = "Описание фильма (опционально)")
    @get:JsonProperty("description") val description: kotlin.String? = null
) {

}

