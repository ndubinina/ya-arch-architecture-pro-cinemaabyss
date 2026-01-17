package ru.arch.cinemaabyss.proxy.api.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param id Уникальный идентификатор подписки
 * @param userId Идентификатор пользователя, оформившего подписку
 * @param planType Тип плана подписки
 * @param startDate Дата начала подписки
 * @param endDate Дата окончания подписки
 */
data class Subscription(

    @Schema(example = "1", required = true, description = "Уникальный идентификатор подписки")
    @get:JsonProperty("id", required = true) val id: kotlin.Int,

    @Schema(example = "1", required = true, description = "Идентификатор пользователя, оформившего подписку")
    @get:JsonProperty("user_id", required = true) val userId: kotlin.Int,

    @Schema(example = "premium", required = true, description = "Тип плана подписки")
    @get:JsonProperty("plan_type", required = true) val planType: kotlin.String,

    @Schema(example = "2023-01-01T00:00Z", required = true, description = "Дата начала подписки")
    @get:JsonProperty("start_date", required = true) val startDate: java.time.OffsetDateTime,

    @Schema(example = "2023-12-31T23:59:59Z", required = true, description = "Дата окончания подписки")
    @get:JsonProperty("end_date", required = true) val endDate: java.time.OffsetDateTime
) {

}

