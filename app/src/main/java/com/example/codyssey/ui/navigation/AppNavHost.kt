package com.example.codyssey.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.codyssey.ui.screens.home.HomeScreen
import com.example.codyssey.ui.screens.journey.JourneyScreen
import com.example.codyssey.ui.screens.profile.ProfileScreen
import com.example.codyssey.ui.screens.projects.ProjectsScreen
import com.example.codyssey.ui.screens.welcome.WelcomeScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    innerPadding: PaddingValues
){
    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ) {

        composable(Screen.Welcome.route){
            WelcomeScreen(
                onGetStarted = {
                    navController.navigate(Screen.Home.route){
                        popUpTo(Screen.Welcome.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(Screen.Home.route) {
            HomeScreen(
                innerPadding = innerPadding
            )
        }
        composable(Screen.Journey.route) {
            JourneyScreen(
                innerPadding = innerPadding
            )
        }
        composable(Screen.Projects.route) {
            ProjectsScreen(
                innerPadding = innerPadding
            )
        }
        composable(Screen.Profile.route) {
            ProfileScreen(
                innerPadding = innerPadding
            )
        }

    }
}