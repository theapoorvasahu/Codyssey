package com.example.codyssey.domain

import com.example.codyssey.model.Lesson

interface LessonRepository {

    fun getLessons(): List<Lesson>

    fun getLesson(id: Int): Lesson?

    fun completeLesson(id: Int)
}