package ru.arch.cinemaabyss.proxy.api.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param userId Идентификатор пользователя, совершающего платеж
 * @param amount Сумма платежа
 */
data class PaymentInput(

    @Schema(example = "1", required = true, description = "Идентификатор пользователя, совершающего платеж")
    @get:JsonProperty("user_id", required = true) val userId: kotlin.Int,

    @Schema(example = "9.99", required = true, description = "Сумма платежа")
    @get:JsonProperty("amount", required = true) val amount: kotlin.Float
) {

}

