package ru.arch.events.api

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.arch.cinemaabyss.proxy.api.EventsApi
import ru.arch.cinemaabyss.proxy.api.model.Event
import ru.arch.cinemaabyss.proxy.api.model.EventResponse
import ru.arch.cinemaabyss.proxy.api.model.MovieEvent
import ru.arch.cinemaabyss.proxy.api.model.PaymentEvent
import ru.arch.cinemaabyss.proxy.api.model.UserEvent
import ru.arch.events.adapter.KafkaProducer
import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneId

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
class EventsController(
    private val kafkaProducer: KafkaProducer,
): EventsApi {
    override fun createMovieEvent(movieEvent: MovieEvent): ResponseEntity<EventResponse> {
        val result = kafkaProducer.publishMovie(movieEvent)
        return ResponseEntity.status(HttpStatus.CREATED).body(
            EventResponse(
                status = "success",
                partition = result.recordMetadata.partition(),
                offset = result.recordMetadata.offset().toInt(),
                event = Event(
                    id = result.producerRecord.key(),
                    type = "movie",
                    timestamp = OffsetDateTime.ofInstant(Instant.ofEpochSecond(result.recordMetadata.timestamp()), ZoneId.systemDefault()),
                    payload = result.producerRecord.value()
                ),
            )
        )
    }

    override fun createUserEvent(userEvent: UserEvent): ResponseEntity<EventResponse> {
        val result = kafkaProducer.publishUser(userEvent)
        return ResponseEntity.status(HttpStatus.CREATED).body(
            EventResponse(
                status = "success",
                partition = result.recordMetadata.partition(),
                offset = result.recordMetadata.offset().toInt(),
                event = Event(
                    id = result.producerRecord.key(),
                    type = "movie",
                    timestamp = OffsetDateTime.ofInstant(Instant.ofEpochSecond(result.recordMetadata.timestamp()), ZoneId.systemDefault()),
                    payload = result.producerRecord.value()
                ),
            )
        )
    }

    override fun createPaymentEvent(paymentEvent: PaymentEvent): ResponseEntity<EventResponse> {
        val result = kafkaProducer.publishPayment(paymentEvent)
        return ResponseEntity.status(HttpStatus.CREATED).body(
            EventResponse(
                status = "success",
                partition = result.recordMetadata.partition(),
                offset = result.recordMetadata.offset().toInt(),
                event = Event(
                    id = result.producerRecord.key(),
                    type = "movie",
                    timestamp = OffsetDateTime.ofInstant(Instant.ofEpochSecond(result.recordMetadata.timestamp()), ZoneId.systemDefault()),
                    payload = result.producerRecord.value()
                ),
            )
        )
    }
}