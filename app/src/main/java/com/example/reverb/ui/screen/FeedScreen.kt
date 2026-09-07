package com.example.reverb.ui.screen

import androidx.compose.runtime.Composable
import com.example.reverb.data.model.Post
import com.example.reverb.ui.component.PostCard

@Composable
fun FeedScreen(post: Post) {
    PostCard(post.username, post.time, post.body, post.likes)
}