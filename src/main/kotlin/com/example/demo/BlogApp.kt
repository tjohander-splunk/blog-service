package com.example.demo

import io.opentelemetry.instrumentation.spring.autoconfigure.EnableOpenTelemetry
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableOpenTelemetry
@SpringBootApplication
class BlogApp

fun main(args: Array<String>) {
    runApplication<BlogApp>(*args)
}
