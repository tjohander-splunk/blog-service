package com.example.demo.service

import com.example.demo.model.Post
import com.example.demo.model.User
import io.micrometer.core.annotation.Timed
import io.micrometer.core.instrument.Counter
import io.micrometer.core.instrument.Metrics
import io.micrometer.core.instrument.Timer
import io.micrometer.core.instrument.cumulative.CumulativeCounter
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

inline fun <reified T : Any> typeRef(): ParameterizedTypeReference<T> = object : ParameterizedTypeReference<T>() {}

@Service
class PostService(
    private val restTemplate: RestTemplate,
    private val myCounter: Counter
) {

    fun fetchPosts(): List<Post>? {
        myCounter.increment()
        val headers = HttpHeaders()
        headers.accept = listOf(MediaType.APPLICATION_JSON)
        val entity = HttpEntity<User>(headers)
        return restTemplate.exchange(
            "/posts",
            HttpMethod.GET,
            entity,
            typeRef<List<Post>>()
        ).body
    }
}