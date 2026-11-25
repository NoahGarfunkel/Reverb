package com.example.reverb.data.repository

import com.example.reverb.data.model.Post
import com.example.reverb.data.network.PostApi
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val postApi: PostApi
) {
    suspend fun getPosts(): List<Post> =
        postApi.getPosts()
}