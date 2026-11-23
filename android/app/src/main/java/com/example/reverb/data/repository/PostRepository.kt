package com.example.reverb.data.repository

import com.example.reverb.data.model.Post
import javax.inject.Inject
import kotlin.time.Clock

class PostRepository @Inject constructor() {
    fun getPosts(): List<Post> = listOf(
        Post(
            username = "@acegickmo",
            time = Clock.System.now(),
            body = "This is a sample post.", likes = 10),
        Post(
            username = "@acegickmo",
            time = Clock.System.now(),
            body = "This is a second sample post.", likes = 100)
    )
}