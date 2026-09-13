package com.example.codyssey.data.local

import com.example.codyssey.model.Lesson
import com.example.codyssey.model.LessonState

fun LessonEntity.toLesson(): Lesson {

    return Lesson(
        id = id,
        questId = 1,
        title = title,
        content = "",
        xpReward = xp,
        state = if (completed)
            LessonState.Completed
        else
            LessonState.Current
    )
}
fun Lesson.toEntity(): LessonEntity {

    return LessonEntity(
        id = id,
        title = title,
        xp = xpReward,
        completed = state == LessonState.Completed
    )
}