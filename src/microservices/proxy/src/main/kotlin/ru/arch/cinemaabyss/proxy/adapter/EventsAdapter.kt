package ru.arch.cinemaabyss.proxy.adapter

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import ru.arch.cinemaabyss.proxy.api.model.EventResponse
import ru.arch.cinemaabyss.proxy.api.model.MovieEvent
import ru.arch.cinemaabyss.proxy.api.model.PaymentEvent
import ru.arch.cinemaabyss.proxy.api.model.UserEvent

@Component
class EventsAdapter(
    @Qualifier("eventsWebClient")
    private val webClient: WebClient,
) {
    fun createMovieEvent(movieEvent: MovieEvent): EventResponse {
        return webClient.post()
            .uri("/api/events/movie")
            .bodyValue(movieEvent)
            .retrieve()
            .bodyToMono(EventResponse::class.java)
            .block()!!
    }

    fun createUserEvent(userEvent: UserEvent): EventResponse {
        return webClient.post()
            .uri("/api/events/user")
            .bodyValue(userEvent)
            .retrieve()
            .bodyToMono(EventResponse::class.java)
            .block()!!
    }

    fun createPaymentEvent(paymentEvent: PaymentEvent): EventResponse {
        return webClient.post()
            .uri("/api/events/payment")
            .bodyValue(paymentEvent)
            .retrieve()
            .bodyToMono(EventResponse::class.java)
            .block()!!
    }
}