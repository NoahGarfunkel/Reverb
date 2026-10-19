package com.example.reverb.data.repository

import com.example.reverb.data.model.Post
import kotlin.time.Clock

class PostRepository {
    fun getPosts(): List<Post> = listOf(
        Post(
            username = "User1",
            time = Clock.System.now(),
            body = "This is a sample post.", likes = 10),
        Post(
            username = "User2",
            time = Clock.System.now(),
            body = "This is a second sample post.", likes = 100)
    )
}