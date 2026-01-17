package ru.arch.events.api

import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.arch.cinemaabyss.proxy.api.HealthApi
import ru.arch.cinemaabyss.proxy.api.model.GetMoviesServiceHealth200Response

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
class HealthController(): HealthApi {
    override fun getEventsServiceHealth(): ResponseEntity<GetMoviesServiceHealth200Response> {
        return ResponseEntity.ok(GetMoviesServiceHealth200Response(status = true))
    }
}