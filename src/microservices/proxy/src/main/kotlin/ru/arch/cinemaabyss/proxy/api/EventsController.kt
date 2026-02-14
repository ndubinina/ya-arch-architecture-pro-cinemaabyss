package ru.arch.cinemaabyss.proxy.api

import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.arch.cinemaabyss.proxy.adapter.EventsAdapter
import ru.arch.cinemaabyss.proxy.api.model.EventResponse
import ru.arch.cinemaabyss.proxy.api.model.MovieEvent
import ru.arch.cinemaabyss.proxy.api.model.PaymentEvent
import ru.arch.cinemaabyss.proxy.api.model.UserEvent

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
class EventsController(
    private val eventsAdapter: EventsAdapter,
): EventsApi {
    override fun createMovieEvent(movieEvent: MovieEvent): ResponseEntity<EventResponse> {
        return ResponseEntity.ok(eventsAdapter.createMovieEvent(movieEvent))
    }

    override fun createPaymentEvent(paymentEvent: PaymentEvent): ResponseEntity<EventResponse> {
        return ResponseEntity.ok(eventsAdapter.createPaymentEvent(paymentEvent))
    }

    override fun createUserEvent(userEvent: UserEvent): ResponseEntity<EventResponse> {
        return ResponseEntity.ok(eventsAdapter.createUserEvent(userEvent))
    }
}