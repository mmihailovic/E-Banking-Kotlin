package org.example.transactionservice.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.DefaultUriBuilderFactory

@Configuration
class BeanConfiguration {
    @Bean
    fun userServiceRestTemplate(): RestTemplate {
        val restTemplate = RestTemplate()
        restTemplate.uriTemplateHandler = DefaultUriBuilderFactory("http://localhost:8080/api")

        return restTemplate
    }
}