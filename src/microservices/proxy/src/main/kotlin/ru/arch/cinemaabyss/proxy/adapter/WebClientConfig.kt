package ru.arch.cinemaabyss.proxy.adapter

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig(
    private val monolithProperties: MonolithProperties,
    private val moviesProperties: MoviesProperties,
    private val eventsProperties: EventsProperties,
) {
    @Bean
    fun monolithWebClient(): WebClient {
        return WebClient.builder()
            .baseUrl(monolithProperties.url)
            .build()
    }

    @Bean
    fun moviesWebClient(): WebClient {
        return WebClient.builder()
            .baseUrl(moviesProperties.url)
            .build()
    }

    @Bean
    fun eventsWebClient(): WebClient {
        return WebClient.builder()
            .baseUrl(eventsProperties.url)
            .build()
    }
}

@Component
@ConfigurationProperties(prefix = "webclient.monolith")
class MonolithProperties {
    lateinit var url: String
    var timeout: Long = 5000
}

@Component
@ConfigurationProperties(prefix = "webclient.movies")
class MoviesProperties {
    lateinit var url: String
    var timeout: Long = 5000
}

@Component
@ConfigurationProperties(prefix = "webclient.events")
class EventsProperties {
    lateinit var url: String
    var timeout: Long = 5000
}