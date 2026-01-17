package ru.arch.cinemaabyss.proxy.api.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid

/**
 * 
 * @param id Уникальный идентификатор события
 * @param type Тип события
 * @param timestamp Время события
 * @param payload Полезная нагрузка события (зависит от типа события)
 */
data class Event(

    @Schema(example = "movie-1-viewed", required = true, description = "Уникальный идентификатор события")
    @get:JsonProperty("id", required = true) val id: kotlin.String,

    @Schema(example = "movie", required = true, description = "Тип события")
    @get:JsonProperty("type", required = true) val type: kotlin.String,

    @Schema(example = "2023-01-15T14:30Z", required = true, description = "Время события")
    @get:JsonProperty("timestamp", required = true) val timestamp: java.time.OffsetDateTime,

    @field:Valid
    @Schema(example = "null", required = true, description = "Полезная нагрузка события (зависит от типа события)")
    @get:JsonProperty("payload", required = true) val payload: kotlin.Any
) {

}

