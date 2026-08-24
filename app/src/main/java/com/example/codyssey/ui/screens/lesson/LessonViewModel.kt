package com.example.codyssey.ui.screens.lesson

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.codyssey.data.FakeLessonRepository

class LessonViewModel : ViewModel() {

    private val initialState = LessonUiState(
        lessons = FakeLessonRepository.lessons
    )

    var uiState by mutableStateOf(initialState)
        private set
}