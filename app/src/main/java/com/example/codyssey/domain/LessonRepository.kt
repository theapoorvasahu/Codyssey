package com.example.codyssey.domain

import com.example.codyssey.model.Lesson

interface LessonRepository {

    suspend fun getLessons(): List<Lesson>

    suspend fun getLesson(id: Int): Lesson?

    suspend fun completeLesson(id: Int)
}