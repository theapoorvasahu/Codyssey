package com.example.codyssey.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val initialState = HomeUiState(
        xp = 34,
        streak = 12,
        progress = 34,
        currentTrack = "Android Development",
        questTitle = "Complete Kotlin Functions",
        questDescription = "Finish today's lesson"
    )

    var uiState by mutableStateOf(initialState)
        private set

    fun addXp() {
        uiState = uiState.copy(
            xp = uiState.xp + 10
        )
    }

    fun completeLesson() {
        uiState = uiState.copy(
            streak = uiState.streak + 1,
            xp = uiState.xp + 10,
            progress = minOf(uiState.progress + 5, 100)
        )
    }

    fun reset() {
        uiState = initialState
    }
}