package com.example.musicsharing.data.model

import kotlin.time.Instant

data class Post(
    val username: String,
    val time: Instant,
    val body: String,
    val likes: Int
)
