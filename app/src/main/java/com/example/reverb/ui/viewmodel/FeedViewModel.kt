package com.example.reverb.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.reverb.data.repository.PostRepository

class FeedViewModel : ViewModel() {
    private val repository = PostRepository()

    val posts = repository.getPosts()
}