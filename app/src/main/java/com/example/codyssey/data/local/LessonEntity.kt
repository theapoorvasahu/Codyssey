package com.example.codyssey.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lessons")
data class LessonEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val xp: Int,
    val completed: Boolean
)