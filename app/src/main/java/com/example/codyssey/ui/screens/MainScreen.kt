package com.example.codyssey.ui.screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.codyssey.ui.components.BottomBar
import com.example.codyssey.ui.navigation.AppNavHost
import com.example.codyssey.ui.navigation.Screen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val backStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry.value?.destination?.route
    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.Welcome.route) {
                BottomBar(
                    currentRoute = currentRoute,
                    onItemClick = { item ->
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) { innerPadding ->

        AppNavHost(
            navController = navController,
            innerPadding = innerPadding
        )

    }
}