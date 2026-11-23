package com.example.reverb.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.reverb.ui.screen.FeedScreen
import com.example.reverb.ui.screen.ProfileScreen
import com.example.reverb.ui.viewmodel.PostViewModel

@Composable
fun ReverbNavigation() {
    val backStack = rememberNavBackStack(Feed)
    val viewModel: PostViewModel = viewModel()

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = backStack.lastOrNull() == Feed,
                    onClick = {
                        backStack.clear()
                        backStack.add(Feed)
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Feed"
                        )
                    },
                    label = {
                        Text("Feed")
                    }
                )
                NavigationBarItem(
                    selected = backStack.lastOrNull() == Profile,
                    onClick = {
                        backStack.clear()
                        backStack.add(Profile)
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Profile icon"
                        )
                    },
                    label = {
                        Text("Profile")
                    }
                )
            }
        }
    ) { innerPadding ->
        NavDisplay(
            backStack = backStack,
            entryProvider = entryProvider {
                entry<Feed> {

                    FeedScreen (viewModel.posts)
                }
                entry<Profile>{
                    ProfileScreen(viewModel.posts)
                }
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}
