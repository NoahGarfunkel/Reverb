package com.example.reverb.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.reverb.data.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    repository: PostRepository
) : ViewModel() {
    val posts = repository.getPosts()
}