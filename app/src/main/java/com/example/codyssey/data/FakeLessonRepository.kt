package com.example.codyssey.data

import com.example.codyssey.model.Lesson
import com.example.codyssey.model.LessonState

object FakeLessonRepository {

    val lessons = listOf(

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
}