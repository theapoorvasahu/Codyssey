package com.example.codyssey.model

data class Lesson(
    val id: Int,
    val questId: Int,
    val title: String,
    val content: String,
    val xpReward: Int,
    val state: LessonState
)