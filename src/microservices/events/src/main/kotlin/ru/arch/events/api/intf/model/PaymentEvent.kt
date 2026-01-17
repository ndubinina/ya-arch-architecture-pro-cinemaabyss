package ru.arch.cinemaabyss.proxy.api.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param paymentId Идентификатор платежа
 * @param userId Идентификатор пользователя
 * @param amount Сумма платежа
 * @param status Статус платежа
 * @param timestamp Время платежа
 * @param methodType Тип метода оплаты (опционально)
 */
data class PaymentEvent(

    @Schema(example = "1", required = true, description = "Идентификатор платежа")
    @get:JsonProperty("payment_id", required = true) val paymentId: kotlin.Int,

    @Schema(example = "1", required = true, description = "Идентификатор пользователя")
    @get:JsonProperty("user_id", required = true) val userId: kotlin.Int,

    @Schema(example = "9.99", required = true, description = "Сумма платежа")
    @get:JsonProperty("amount", required = true) val amount: kotlin.Float,

    @Schema(example = "completed", required = true, description = "Статус платежа")
    @get:JsonProperty("status", required = true) val status: kotlin.String,

    @Schema(example = "2023-01-15T14:30Z", required = true, description = "Время платежа")
    @get:JsonProperty("timestamp", required = true) val timestamp: java.time.OffsetDateTime,

    @Schema(example = "credit_card", description = "Тип метода оплаты (опционально)")
    @get:JsonProperty("method_type") val methodType: kotlin.String? = null
) {

}

