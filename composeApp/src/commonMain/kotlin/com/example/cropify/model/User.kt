package com.example.cropify.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val username: String,
    val password: String,
    val role: String,
)