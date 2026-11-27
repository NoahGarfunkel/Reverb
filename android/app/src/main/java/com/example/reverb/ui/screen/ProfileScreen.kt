package com.example.reverb.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.reverb.data.model.Post
import com.example.reverb.ui.viewmodel.PostViewModel

@Composable
fun ProfileScreen(viewModel: PostViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Profile picture",
                    modifier = Modifier.size(64.dp)
                )
                Text("Noah Garfunkel", style = MaterialTheme.typography.titleLarge)
                Text("@acegickmo", style = MaterialTheme.typography.bodyMedium)
                Text("I loooooove making Kotlin app, it's so fun and wacky and I am learning so much omg thank you copilot haha")
                HorizontalDivider()
                Row(horizontalArrangement = Arrangement.spacedBy(24.dp)){
                    Text("9999 posts")
                    Text("9999 followers")
                    Text("9999 following")
                }
                Button(onClick = {}) {
                    Text("Edit profile")
                }
            }
        }

        items(uiState.posts) { post ->
            ProfilePost(post)
        }
    }
}

@Composable
private fun ProfilePost(post: Post) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Text(
            post.body, modifier = Modifier.padding(16.dp)
        )
    }
}