package com.example.codyssey.data.quest

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quests")
data class QuestEntity(

    @PrimaryKey
    val id: Int,

    val title: String,

    val description: String,

    val xpReward: Int,

    val unlocked: Boolean,

    val completed: Boolean
)