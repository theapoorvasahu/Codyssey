package com.example.codyssey.ui.screens.home

data class HomeUiState(
    val xp: Int = 0,
    val streak: Int = 0,
    val progress: Int = 34,
    val currentTrack: String = "",
    val questTitle: String = "",
    val questDescription: String = ""
)