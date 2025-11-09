package org.example.transactionservice.configuration

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.DirectExchange
import org.springframework.amqp.core.Queue
import org.springframework.amqp.support.converter.SimpleMessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfiguration {
    @Value("\${transactions.required.queue}")
    lateinit var TRANSACTIONS_REQUIRED_QUEUE: String

    @Value("\${transactions.required.exchange}")
    lateinit var EXCHANGE: String

    @Value("\${transactions.required.routing.key}")
    lateinit var ROUTING_KEY: String

    @Bean
    fun converter(): SimpleMessageConverter {
        val converter = SimpleMessageConverter()
        converter.setAllowedListPatterns(listOf("*"))
        return converter
    }

    @Bean
    fun queue(): Queue {
        return Queue(TRANSACTIONS_REQUIRED_QUEUE)
    }

    @Bean
    fun exchange(): DirectExchange {
        return DirectExchange(EXCHANGE)
    }

    @Bean
    fun bind(): Binding {
        return BindingBuilder.bind(queue())
            .to(exchange())
            .with(ROUTING_KEY)
    }
}