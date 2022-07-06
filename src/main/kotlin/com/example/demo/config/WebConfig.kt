package com.example.demo.config

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

    // Unregister the OpenTelemetryMeterRegistry from Metrics.globalRegistry and make it available
    // as a Spring bean instead.
//    @Bean
//    @ConditionalOnClass(name = ["io.opentelemetry.javaagent.OpenTelemetryAgent"])
//    fun otelRegistry(): MeterRegistry? {
//        val otelRegistry: Optional<MeterRegistry> = Metrics.globalRegistry.getRegistries().stream()
//            .map {
//                println(it.config().namingConvention())
//                it
//            }
//            .filter { r -> r::class.java.getName().contains("OpenTelemetryMeterRegistry") }
//            .findAny()
//        otelRegistry.ifPresent(Metrics.globalRegistry::remove)
//        return otelRegistry.orElse(null)
//    }

}