package com.example.codyssey.ui.screens.lesson

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

import com.example.codyssey.domain.LessonRepository
import com.example.codyssey.model.Lesson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class LessonViewModel @Inject constructor(
    private val repository: LessonRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow(
            LessonUiState()
        )

    val uiState: StateFlow<LessonUiState> =
        _uiState.asStateFlow()

    init {

        viewModelScope.launch {

            _uiState.value =
                _uiState.value.copy(
                    lessons = repository.getLessons()
                )

        }

    }
    fun completeLesson(id: Int) {

        viewModelScope.launch {

            repository.completeLesson(id)

            _uiState.value =
                _uiState.value.copy(
                    lessons = repository.getLessons()
                )

        }

    }

    fun getLesson(id: Int): Lesson? {
        return _uiState.value.lessons.find { it.id == id }
    }
}