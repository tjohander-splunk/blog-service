package com.example.demo.config

import org.springframework.boot.actuate.metrics.web.client.MetricsRestTemplateCustomizer
import org.springframework.boot.autoconfigure.web.client.RestTemplateBuilderConfigurer
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.boot.web.client.RootUriTemplateHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class WebConfig {

    // This is needed for Micrometer metrics
    @Bean
    fun restTemplate(restTemplateBuilder: RestTemplateBuilder): RestTemplate? {
        val rootUriTemplateHandler = RootUriTemplateHandler("https://jsonplaceholder.typicode.com")
        return restTemplateBuilder.uriTemplateHandler(rootUriTemplateHandler)
            .build()
    }
}