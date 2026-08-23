package com.example.codyssey.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.codyssey.data.FakeQuestRepository

class HomeViewModel : ViewModel() {

    private val allQuests = FakeQuestRepository.getQuests()
    private val initialState = HomeUiState(
        xp = 34,
        streak = 12,
        currentTrack = "Android Development",
        quests = allQuests
    )

    var uiState by mutableStateOf(initialState)
        private set

    fun addXp() {
        uiState = uiState.copy(
            xp = uiState.xp + 10
        )
    }

    fun completeLesson() {
        val reward = uiState.quests.firstOrNull()?.xpReward ?: 0

        uiState = uiState.copy(
            streak = uiState.streak + 1,
            xp = uiState.xp + reward,
            progress = minOf(uiState.progress + 5, 100)
        )
    }

    fun reset() {
        uiState = initialState
    }
}