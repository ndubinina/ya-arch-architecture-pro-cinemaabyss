package ru.arch.cinemaabyss.proxy.api.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid

/**
 * 
 * @param status Статус операции
 * @param partition Партиция Kafka
 * @param offset Смещение в партиции Kafka
 * @param event 
 */
data class EventResponse(

    @Schema(example = "success", required = true, description = "Статус операции")
    @get:JsonProperty("status", required = true) val status: kotlin.String,

    @Schema(example = "0", required = true, description = "Партиция Kafka")
    @get:JsonProperty("partition", required = true) val partition: kotlin.Int,

    @Schema(example = "42", required = true, description = "Смещение в партиции Kafka")
    @get:JsonProperty("offset", required = true) val offset: kotlin.Int,

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @get:JsonProperty("event", required = true) val event: Event
) {

}

