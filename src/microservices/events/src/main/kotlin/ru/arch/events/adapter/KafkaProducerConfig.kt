package ru.arch.events.adapter

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.support.serializer.JsonSerializer
import ru.arch.cinemaabyss.proxy.api.model.MovieEvent
import ru.arch.cinemaabyss.proxy.api.model.PaymentEvent
import ru.arch.cinemaabyss.proxy.api.model.UserEvent

@Configuration
class KafkaProducerConfig() {
    @Value("\${kafka.bootstrap.servers}")
    lateinit var kafkaBootstrapServers: String

    @Bean
    fun producerUserFactory(): ProducerFactory<String, UserEvent> {
        val props = mutableMapOf<String, Any>(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaBootstrapServers,
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java.getName(),
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to JsonSerializer::class.java.getName(),
            ProducerConfig.ACKS_CONFIG to "all",
            ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG to "true",
            "spring.json.add.type.headers" to false,
        )

        return DefaultKafkaProducerFactory(props)
    }

    @Bean
    fun kafkaUserTemplate(): KafkaTemplate<String, UserEvent> {
        return KafkaTemplate(producerUserFactory())
    }

    @Bean
    fun producerPaymentFactory(): ProducerFactory<String, PaymentEvent> {
        val props = mutableMapOf<String, Any>(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaBootstrapServers,
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java.getName(),
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to JsonSerializer::class.java.getName(),
            ProducerConfig.ACKS_CONFIG to "all",
            ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG to "true",
            "spring.json.add.type.headers" to false,
        )

        return DefaultKafkaProducerFactory(props)
    }

    @Bean
    fun kafkaPaymentTemplate(): KafkaTemplate<String, PaymentEvent> {
        return KafkaTemplate(producerPaymentFactory())
    }

    @Bean
    fun producerMovieFactory(): ProducerFactory<String, MovieEvent> {
        val props = mutableMapOf<String, Any>(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaBootstrapServers,
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java.getName(),
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to JsonSerializer::class.java.getName(),
            ProducerConfig.ACKS_CONFIG to "all",
            ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG to "true",
            "spring.json.add.type.headers" to false,
        )

        return DefaultKafkaProducerFactory(props)
    }

    @Bean
    fun kafkaMovieTemplate(): KafkaTemplate<String, MovieEvent> {
        return KafkaTemplate(producerMovieFactory())
    }
}