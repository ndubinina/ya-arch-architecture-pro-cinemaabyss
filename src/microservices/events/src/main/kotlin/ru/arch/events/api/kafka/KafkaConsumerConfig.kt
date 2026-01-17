package ru.arch.events.api.kafka

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer
import ru.arch.cinemaabyss.proxy.api.model.MovieEvent
import ru.arch.cinemaabyss.proxy.api.model.PaymentEvent
import ru.arch.cinemaabyss.proxy.api.model.UserEvent

@EnableKafka
@Configuration
class KafkaConsumerConfig {
    @Value("\${kafka.bootstrap.servers}")
    lateinit var kafkaBootstrapServers: String

    @Value("\${kafka.consumer_group}")
    lateinit var kafkaConsumerGroup: String

    @Bean
    fun consumerUserFactory(): ConsumerFactory<String, UserEvent> {
        val deserializer = JsonDeserializer(UserEvent::class.java)
        deserializer.addTrustedPackages("*")

        val props = mapOf<String, Any>(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaBootstrapServers,
            ConsumerConfig.GROUP_ID_CONFIG to kafkaConsumerGroup,
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to deserializer
        )
        return DefaultKafkaConsumerFactory(props, StringDeserializer(), deserializer)
    }

    @Bean
    fun kafkaUserListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, UserEvent> {
        return ConcurrentKafkaListenerContainerFactory<String, UserEvent>().apply {
            setConsumerFactory(consumerUserFactory())
        }
    }

    @Bean
    fun consumerMovieFactory(): ConsumerFactory<String, MovieEvent> {
        val deserializer = JsonDeserializer(MovieEvent::class.java)
        deserializer.addTrustedPackages("*")

        val props = mapOf<String, Any>(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaBootstrapServers,
            ConsumerConfig.GROUP_ID_CONFIG to kafkaConsumerGroup,
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to deserializer
        )
        return DefaultKafkaConsumerFactory(props, StringDeserializer(), deserializer)
    }

    @Bean
    fun kafkaMovieListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, MovieEvent> {
        return ConcurrentKafkaListenerContainerFactory<String, MovieEvent>().apply {
            setConsumerFactory(consumerMovieFactory())
        }
    }

    @Bean
    fun consumerPaymentFactory(): ConsumerFactory<String, PaymentEvent> {
        val deserializer = JsonDeserializer(PaymentEvent::class.java)
        deserializer.addTrustedPackages("*")

        val props = mapOf<String, Any>(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaBootstrapServers,
            ConsumerConfig.GROUP_ID_CONFIG to kafkaConsumerGroup,
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to deserializer
        )
        return DefaultKafkaConsumerFactory(props, StringDeserializer(), deserializer)
    }

    @Bean
    fun kafkaPaymentListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, PaymentEvent> {
        return ConcurrentKafkaListenerContainerFactory<String, PaymentEvent>().apply {
            setConsumerFactory(consumerPaymentFactory())
        }
    }
}