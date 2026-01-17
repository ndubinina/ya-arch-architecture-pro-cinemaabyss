package ru.arch.events.api.kafka

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import ru.arch.cinemaabyss.proxy.api.model.MovieEvent
import ru.arch.cinemaabyss.proxy.api.model.PaymentEvent
import ru.arch.cinemaabyss.proxy.api.model.UserEvent

@Service
class KafkaListeners {
    @KafkaListener(
        topics = ["user-events"],
        groupId = "events-group",
        containerFactory = "kafkaUserListenerContainerFactory"
    )
    fun listenUserEvents(userEvent: UserEvent) {
        println("Read user ${userEvent} from kafka")
    }

    @KafkaListener(
        topics = ["payment-events"],
        groupId = "events-group",
        containerFactory = "kafkaPaymentListenerContainerFactory"
    )
    fun listenPaymentEvents(paymentEvent: PaymentEvent) {
        println("Read payment ${paymentEvent} from kafka")
    }

    @KafkaListener(
        topics = ["movie-events"],
        groupId = "events-group",
        containerFactory = "kafkaMovieListenerContainerFactory"
    )
    fun listenMovieEvents(movieEvent: MovieEvent) {
        println("Read movie ${movieEvent} from kafka")
    }
}