package com.example.reverb.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.reverb.data.model.Post
import com.example.reverb.ui.component.PostCard

@Composable
fun FeedScreen(posts: List<Post>) {
    LazyColumn{
        items(posts) { post ->
            PostCard(post.username, post.time, post.body, post.likes)
        }
    }
}