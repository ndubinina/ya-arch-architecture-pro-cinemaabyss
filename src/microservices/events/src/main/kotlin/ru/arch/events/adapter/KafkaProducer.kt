package ru.arch.events.adapter

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Service
import ru.arch.cinemaabyss.proxy.api.model.MovieEvent
import ru.arch.cinemaabyss.proxy.api.model.PaymentEvent
import ru.arch.cinemaabyss.proxy.api.model.UserEvent

@Service
class KafkaProducer(
    private val kafkaUserTemplate: KafkaTemplate<String, UserEvent>,
    private val kafkaPaymentTemplate: KafkaTemplate<String, PaymentEvent>,
    private val kafkaMovieTemplate: KafkaTemplate<String, MovieEvent>
) {
    fun publishUser(userEvent: UserEvent): SendResult<String, UserEvent> {
        val result = kafkaUserTemplate.send(
            "user-events",
            userEvent.userId.toString(),
            userEvent,
        ).get()!!
        println("${userEvent} was send to user-events")
        return result
    }

    fun publishPayment(paymentEvent: PaymentEvent): SendResult<String, PaymentEvent> {
        val result = kafkaPaymentTemplate.send(
            "payment-events",
            paymentEvent.paymentId.toString(),
            paymentEvent,
        ).get()!!
        println("${paymentEvent} was send to payment-events")
        return result
    }

    fun publishMovie(movieEvent: MovieEvent): SendResult<String, MovieEvent> {
        val result = kafkaMovieTemplate.send(
            "movie-events",
            movieEvent.movieId.toString(),
            movieEvent,
        ).get()!!
        println("${movieEvent} was send to movie-events")
        return result
    }
}