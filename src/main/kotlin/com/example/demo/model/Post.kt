package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Post(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String,
)
