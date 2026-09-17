package com.example.codyssey.data.profile

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_profile")
data class UserProfileEntity(

    @PrimaryKey
    val id: Int = 1,

    val name: String,

    val xp: Int,

    val streak: Int,

    val longestStreak: Int,

    val achievementsUnlocked: Int
)