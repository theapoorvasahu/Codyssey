package com.example.codyssey.ui.playground

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PlaygroundViewModel : ViewModel() {

    var uiState by mutableStateOf(PlaygroundUiState())
        private set

    fun addXp() {
        uiState = uiState.copy(
            xp = uiState.xp + 10
        )
    }

    fun completeLesson() {
        uiState = uiState.copy(
            streak = uiState.streak + 1,
            lessons = uiState.lessons + 1
        )
    }

    fun reset() {
        uiState = PlaygroundUiState()
    }
}