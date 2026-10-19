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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.reverb.ui.screen.FeedScreen
import com.example.reverb.ui.viewmodel.FeedViewModel
import kotlinx.serialization.Serializable

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
                    val viewModel: FeedViewModel = viewModel()
                    FeedScreen (viewModel.posts)
                }
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}
