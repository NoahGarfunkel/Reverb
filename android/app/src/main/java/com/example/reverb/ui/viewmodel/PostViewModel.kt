package com.example.reverb.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reverb.data.model.Post
import com.example.reverb.data.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.io.IOException
import javax.inject.Inject

data class PostsUiState(
    val posts: List<Post> = emptyList(),
    val errorMessage: String? = null
)

@HiltViewModel
class PostViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(PostsUiState())
    val uiState: StateFlow<PostsUiState> = _uiState.asStateFlow()

    init {
        loadPosts()
    }

    fun loadPosts() {
        viewModelScope.launch {
            try {
                _uiState.value = PostsUiState(posts = repository.getPosts())
            } catch (_: IOException) {
                _uiState.update { current ->
                    current.copy(errorMessage = "Couldn't connect to the server.")
                }
            }

        }
    }
}