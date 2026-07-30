package com.example.codyssey.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.codyssey.ui.navigation.AppNavHost


@Composable
fun CodysseyApp(){
    val navController = rememberNavController()

    AppNavHost(
        navController = navController
    )
}