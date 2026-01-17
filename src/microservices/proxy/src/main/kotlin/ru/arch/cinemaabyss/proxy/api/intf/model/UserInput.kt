package ru.arch.cinemaabyss.proxy.api.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Email

/**
 * 
 * @param username Имя пользователя
 * @param email Email пользователя
 */
data class UserInput(

    @Schema(example = "john_doe", required = true, description = "Имя пользователя")
    @get:JsonProperty("username", required = true) val username: kotlin.String,

    @get:Email
    @Schema(example = "john.doe@example.com", required = true, description = "Email пользователя")
    @get:JsonProperty("email", required = true) val email: kotlin.String
) {

}

