package com.example.musicsharing.ui.screen

import androidx.compose.runtime.Composable
import com.example.musicsharing.data.model.Post
import com.example.musicsharing.ui.component.PostCard

@Composable
fun FeedScreen(post: Post) {
    PostCard(post.username, post.time, post.body, post.likes)
}