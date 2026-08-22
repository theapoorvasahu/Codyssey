package com.example.codyssey.ui.screens.home

import com.example.codyssey.model.Quest

data class HomeUiState(
    val xp: Int = 0,
    val streak: Int = 0,
    val progress: Int = 0,
    val currentTrack: String = "",
    val quest: Quest? = null
)