package com.example.codyssey.ui.screens.lesson

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.codyssey.domain.LessonRepository

class LessonViewModelFactory(
    private val repository: LessonRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {
        if (modelClass.isAssignableFrom(LessonViewModel::class.java)) {
            return LessonViewModel(repository) as T
        }
        throw IllegalArgumentException(
            "Unknown ViewModel class"
        )
    }
}