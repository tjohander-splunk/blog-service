package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.cglib.proxy.InterfaceMaker

@JsonIgnoreProperties(ignoreUnknown = true)
data class Album(
    val id: Int,
    val userId: Int,
    val title: String
)