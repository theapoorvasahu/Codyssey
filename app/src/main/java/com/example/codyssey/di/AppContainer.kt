package com.example.codyssey.di

import com.example.codyssey.data.FakeLessonRepository
import com.example.codyssey.domain.LessonRepository

interface AppContainer {
    val lessonRepository : LessonRepository
}

class DefaultAppContainer : AppContainer {
    override val lessonRepository: LessonRepository =
        FakeLessonRepository
}