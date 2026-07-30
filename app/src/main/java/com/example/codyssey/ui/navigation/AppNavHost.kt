package com.example.codyssey.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
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
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ) {

        composable(Screen.Welcome.route){
            WelcomeScreen(
                onGetStarted = {
                    navController.navigate(Screen.Home.route)
                }
            )
        }
        composable(Screen.Home.route) {
            HomeScreen()
        }
        composable(Screen.Journey.route) {
            JourneyScreen()
        }
        composable(Screen.Projects.route) {
            ProjectsScreen()
        }
        composable(Screen.Profile.route) {
            ProfileScreen()
        }

    }
}