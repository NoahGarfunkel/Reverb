package com.example.reverb.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reverb.data.model.Post
import com.example.reverb.data.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    repository: PostRepository
) : ViewModel() {
    var posts by mutableStateOf<List<Post>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            posts = repository.getPosts()
        }
    }
}