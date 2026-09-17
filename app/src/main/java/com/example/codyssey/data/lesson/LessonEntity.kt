package com.example.codyssey.data.lesson

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.codyssey.model.LessonState

@Entity(tableName = "lessons")
data class LessonEntity(

    @PrimaryKey
    val id: Int,

    val questId: Int,

    val title: String,

    val content: String,

    val xpReward: Int,

    val state: LessonState
)