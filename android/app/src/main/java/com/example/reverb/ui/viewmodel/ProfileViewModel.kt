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

data class ProfileUiState(
    val posts: List<Post> = emptyList(),
    val errorMessage: String? = null,
    val isLoading: Boolean = false
)

private const val CURRENT_USERNAME = "@acegickmo"

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    init {
        loadPosts()
    }

    fun loadPosts() {
        viewModelScope.launch {
            if (_uiState.value.isLoading) return@launch

            try {
                _uiState.update { it.copy(isLoading = true) }
                val posts = repository.getPosts(CURRENT_USERNAME)
                _uiState.update { it.copy(posts = posts, errorMessage = null) }
            } catch (_: IOException) {
                _uiState.update { current ->
                    current.copy(errorMessage = "Couldn’t load posts. Pull down to try again.")
                }
            } finally {
                _uiState.update { it.copy(isLoading = false) }
            }

        }
    }

    fun clearError() {
        _uiState.update { it.copy(errorMessage = null) }
    }
}