package com.example.reverb.data.network

import com.example.reverb.data.model.Post
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class PostApi @Inject constructor(
    private val client: HttpClient
) {
    suspend fun getPosts(): List<Post> =
        client.get("posts").body()
}