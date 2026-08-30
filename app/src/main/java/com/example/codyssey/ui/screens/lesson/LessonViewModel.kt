package com.example.codyssey.ui.screens.lesson

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.ViewModel
import com.example.codyssey.data.FakeLessonRepository
import com.example.codyssey.domain.LessonRepository
import com.example.codyssey.model.Lesson

class LessonViewModel : ViewModel() {

    private val repository: LessonRepository = FakeLessonRepository

    private val initialState = LessonUiState(
        lessons = repository.getLessons()
    )

    private val _uiState = MutableStateFlow(initialState)

    val uiState: StateFlow<LessonUiState> =
        _uiState.asStateFlow()

    fun completeLesson(id: Int) {

        val updatedLessons = repository.completeLesson(
            lessons = _uiState.value.lessons,
            id = id
        )

        _uiState.value =
            _uiState.value.copy(
                lessons = updatedLessons
            )
    }
    fun getLesson(id: Int): Lesson? {
        return _uiState.value.lessons.find { it.id == id }
    }
}