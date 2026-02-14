package ru.arch.cinemaabyss.proxy.adapter

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import ru.arch.cinemaabyss.proxy.api.model.Movie

@Component
class MoviesAdapter(
    @Qualifier("moviesWebClient")
    private val webClient: WebClient,
) {
    fun getAllMovies(): List<Movie> {
        return webClient.get()
            .uri("/api/movies")
            .retrieve()
            .bodyToFlux(Movie::class.java)
            .collectList()
            .block() ?: emptyList()
    }
}