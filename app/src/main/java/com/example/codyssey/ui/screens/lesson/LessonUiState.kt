package com.example.codyssey.ui.screens.lesson

import com.example.codyssey.model.Lesson

data class LessonUiState(

    val lessons: List<Lesson> = emptyList(),

    val completedLessons: Int = 0

)