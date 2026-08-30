package com.example.codyssey.data

import com.example.codyssey.domain.LessonRepository
import com.example.codyssey.model.Lesson
import com.example.codyssey.model.LessonState

object FakeLessonRepository : LessonRepository {

    private val lessons = listOf(

        Lesson(
            id = 1,
            questId = 1,
            title = "Variables",
            content = "Learn Kotlin variables.",
            xpReward = 5,
            state = LessonState.Completed
        ),

        Lesson(
            id = 2,
            questId = 1,
            title = "Functions",
            content = "Learn Kotlin functions.",
            xpReward = 5,
            state = LessonState.Current
        ),
        Lesson(
            id = 3,
            questId = 2,
            title = "OOP",
            content = "Learn Kotlin classes and objects.",
            xpReward = 10,
            state = LessonState.Locked
        ),

        Lesson(
            id = 4,
            questId = 2,
            title = "Collections",
            content = "Learn Lists, Sets and Maps.",
            xpReward = 10,
            state = LessonState.Locked
        ),

        Lesson(
            id = 5,
            questId = 2,
            title = "Coroutines",
            content = "Learn asynchronous programming.",
            xpReward = 15,
            state = LessonState.Locked
        )
    )

    override fun getLessons(): List<Lesson> {
        return lessons
    }

    override fun getLesson(id: Int): Lesson? {
        return lessons.find { it.id == id }
    }

    override fun completeLesson(
        lessons: List<Lesson>,
        id: Int
    ): List<Lesson>{
        return lessons.map { lesson ->

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