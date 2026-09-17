package com.example.codyssey.data

import com.example.codyssey.data.lesson.LessonSeedData
import com.example.codyssey.domain.LessonRepository
import com.example.codyssey.model.Lesson
import com.example.codyssey.model.LessonState

object FakeLessonRepository : LessonRepository {

    private var lessons = LessonSeedData.defaultLessons

    override suspend fun getLessons(): List<Lesson> {
        return lessons
    }

    override suspend fun getLesson(id: Int): Lesson? {
        return lessons.find { it.id == id }
    }

    override suspend fun completeLesson(id: Int) {

        lessons = lessons.map { lesson ->

            when {
                lesson.id == id ->
                    lesson.copy(state = LessonState.Completed)

                lesson.id == id + 1 ->
                    lesson.copy(state = LessonState.Current)

                else ->
                    lesson
            }

        }

    }
}