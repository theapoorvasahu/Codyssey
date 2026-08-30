package com.example.codyssey.ui.screens.lesson

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.codyssey.data.FakeLessonRepository
import com.example.codyssey.model.Lesson
import com.example.codyssey.model.LessonState

class LessonViewModel : ViewModel() {

    private val initialState = LessonUiState(
        lessons = FakeLessonRepository.lessons
    )

    var uiState by mutableStateOf(initialState)
        private set

    fun completeLesson(id: Int) {

        val updatedLessons =
            uiState.lessons.map { lesson ->

                when {
                    lesson.id == id ->
                        lesson.copy(state = LessonState.Completed)

                    lesson.id == id + 1 ->
                        lesson.copy(state = LessonState.Current)

                    else ->
                        lesson
                }

            }

        uiState = uiState.copy(
            lessons = updatedLessons
        )
    }
    fun getLesson(id: Int): Lesson? {
        return uiState.lessons.find { it.id == id }
    }
}