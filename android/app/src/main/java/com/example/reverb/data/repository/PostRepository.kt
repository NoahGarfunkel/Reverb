package com.example.reverb.data.repository

import com.example.reverb.data.model.Post
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val client: HttpClient
) {
    suspend fun getPosts(username: String? = null): List<Post> =
        client.get("posts") {
            parameter("username", username)
        }.body()
}