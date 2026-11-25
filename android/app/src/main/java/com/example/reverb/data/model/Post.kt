package com.example.reverb.data.model

import kotlinx.serialization.Serializable
import kotlin.time.Instant

@Serializable
data class Post(
    val username: String,
    val time: Instant,
    val body: String,
    val likes: Int
)
