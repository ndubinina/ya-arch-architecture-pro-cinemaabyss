package ru.arch.cinemaabyss.proxy.api.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param id Уникальный идентификатор платежа
 * @param userId Идентификатор пользователя, совершившего платеж
 * @param amount Сумма платежа
 * @param timestamp Время совершения платежа
 */
data class Payment(

    @Schema(example = "1", required = true, description = "Уникальный идентификатор платежа")
    @get:JsonProperty("id", required = true) val id: kotlin.Int,

    @Schema(example = "1", required = true, description = "Идентификатор пользователя, совершившего платеж")
    @get:JsonProperty("user_id", required = true) val userId: kotlin.Int,

    @Schema(example = "9.99", required = true, description = "Сумма платежа")
    @get:JsonProperty("amount", required = true) val amount: kotlin.Float,

    @Schema(example = "2023-01-15T14:30Z", required = true, description = "Время совершения платежа")
    @get:JsonProperty("timestamp", required = true) val timestamp: java.time.OffsetDateTime
) {

}

