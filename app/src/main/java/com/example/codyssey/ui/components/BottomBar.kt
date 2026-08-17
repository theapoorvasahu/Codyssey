package com.example.codyssey.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.codyssey.ui.navigation.BottomNavItem
import com.example.codyssey.ui.navigation.Screen

private val items = listOf(
    BottomNavItem(
        title = "Home",
        icon = Icons.Default.Home,
        route = Screen.Home.route
    ),
    BottomNavItem(
        title = "Journey",
        icon = Icons.Default.Map,
        route = Screen.Journey.route
    ),
    BottomNavItem(
        title = "Projects",
        icon = Icons.Default.Code,
        route = Screen.Projects.route
    ),
    BottomNavItem(
        title = "Profile",
        icon = Icons.Default.Person,
        route = Screen.Profile.route
    )
)

@Composable
fun BottomBar(
    currentRoute: String?,
    onItemClick: (BottomNavItem) -> Unit
){
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    onItemClick(item)
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(item.title)
                }
            )
        }
    }
}