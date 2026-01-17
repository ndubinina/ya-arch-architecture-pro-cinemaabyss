package ru.arch.cinemaabyss.proxy.api

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
class HealthController(): HealthApi {
    override fun getProxyHealth(): ResponseEntity<String> {
        return ResponseEntity(HttpStatus.OK)
    }
}