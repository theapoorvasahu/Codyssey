package com.example.codyssey.ui.navigation


sealed class Screen(
    val route: String
) {

    data object Welcome : Screen("welcome")

    data object Home : Screen("home")

    data object Journey : Screen("journey")

    data object Profile : Screen("profile")

    data object Projects : Screen("projects")

}