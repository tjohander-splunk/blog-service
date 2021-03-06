package com.example.demo.service

import com.example.demo.model.Post
import com.example.demo.model.User
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
    private val getRestTemplate: RestTemplate
) {

    fun fetchPosts(): List<Post>? {
        val headers = HttpHeaders()
        headers.accept = listOf(MediaType.APPLICATION_JSON)
        val entity = HttpEntity<User>(headers)
        return getRestTemplate.exchange(
            "https://jsonplaceholder.typicode.com/posts",
            HttpMethod.GET,
            entity,
            typeRef<List<Post>>()
        ).body
    }
}