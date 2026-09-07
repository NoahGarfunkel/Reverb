package com.example.reverb.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.reverb.data.model.Post
import com.example.reverb.ui.screen.FeedScreen
import kotlinx.serialization.Serializable
import kotlin.time.Clock

@Serializable
data object Feed : NavKey

@Composable
fun ReverbNavigation() {
    val backStack = rememberNavBackStack(Feed)

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = true,
                    onClick = {
                        backStack.add(Feed)
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home"
                        )
                    }
                )
            }
        }
    ) { innerPadding ->
        NavDisplay(
            backStack = backStack,
            entryProvider = entryProvider {
                entry<Feed> {
                    val postCard = Post(
                        username = "User1",
                        time = Clock.System.now(),
                        body = "This is a sample post.", likes = 10
                    )
                    FeedScreen(postCard)
                }
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}
