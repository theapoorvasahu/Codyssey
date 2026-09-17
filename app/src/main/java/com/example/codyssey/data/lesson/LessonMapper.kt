package com.example.codyssey.data.lesson

import com.example.codyssey.model.Lesson

fun LessonEntity.toLesson() = Lesson(
    id = id,
    questId = questId,
    title = title,
    content = content,
    xpReward = xpReward,
    state = state
)
fun Lesson.toEntity() = LessonEntity(
    id = id,
    questId = questId,
    title = title,
    content = content,
    xpReward = xpReward,
    state = state
)
