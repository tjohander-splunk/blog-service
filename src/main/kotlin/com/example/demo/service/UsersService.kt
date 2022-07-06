package com.example.demo.service

import com.example.demo.model.User
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class UsersService(
    private val getRestTemplate: RestTemplate
) {

    fun fetchUsers(): List<User>? {
        val headers = HttpHeaders()
        headers.accept = listOf(MediaType.APPLICATION_JSON)
        val entity = HttpEntity<List<User>>(headers)
        return getRestTemplate.exchange(
            "https://jsonplaceholder.typicode.com/users",
            HttpMethod.GET,
            entity,
            typeRef<List<User>>()
        ).body
    }

    fun fetchOneUser(id: Int): User? {
        val headers = HttpHeaders()
        headers.accept = listOf(MediaType.APPLICATION_JSON)
        val entity = HttpEntity<User>(headers)
        return getRestTemplate.exchange(
            "https://jsonplaceholder.typicode.com/users/$id",
            HttpMethod.GET,
            entity,
            User::class.java
        ).body
    }
}