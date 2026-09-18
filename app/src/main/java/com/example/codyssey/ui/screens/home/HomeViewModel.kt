package com.example.codyssey.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codyssey.domain.QuestRepository
import com.example.codyssey.domain.UserProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val questRepository: QuestRepository,
    private val userProfileRepository: UserProfileRepository
) : ViewModel() {

    init {
        loadHome()
    }

    private fun loadHome() {
        viewModelScope.launch {

            val quests = questRepository.getQuests()
            val profile = userProfileRepository.getProfile()

            uiState = uiState.copy(
                quests = quests,
                xp = profile.xp,
                streak = profile.streak
            )
        }
    }

    var uiState by mutableStateOf(HomeUiState())
        private set



    fun reset() {
        loadHome()
    }
}