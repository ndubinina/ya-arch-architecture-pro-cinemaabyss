package ru.arch.cinemaabyss.proxy.api.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param userId Идентификатор пользователя
 * @param action Действие пользователя
 * @param timestamp Время события
 * @param username Имя пользователя (опционально)
 * @param email Email пользователя (опционально)
 */
data class UserEvent(

    @Schema(example = "1", required = true, description = "Идентификатор пользователя")
    @get:JsonProperty("user_id", required = true) val userId: kotlin.Int,

    @Schema(example = "registered", required = true, description = "Действие пользователя")
    @get:JsonProperty("action", required = true) val action: kotlin.String,

    @Schema(example = "2023-01-15T14:30Z", required = true, description = "Время события")
    @get:JsonProperty("timestamp", required = true) val timestamp: java.time.OffsetDateTime,

    @Schema(example = "john_doe", description = "Имя пользователя (опционально)")
    @get:JsonProperty("username") val username: kotlin.String? = null,

    @Schema(example = "john.doe@example.com", description = "Email пользователя (опционально)")
    @get:JsonProperty("email") val email: kotlin.String? = null
) {

}

