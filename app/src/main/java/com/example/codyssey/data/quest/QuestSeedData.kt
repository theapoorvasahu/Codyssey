package com.example.codyssey.data.quest

import com.example.codyssey.model.Quest

object QuestSeedData {

    val defaultQuests = listOf(

        Quest(
            id = 1,
            title = "Kotlin Basics",
            description = "Learn Kotlin fundamentals",
            xpReward = 100,
            unlocked = true,
            completed = false
        ),

        Quest(
            id = 2,
            title = "Control Flow",
            description = "Master conditions and loops",
            xpReward = 150,
            unlocked = false,
            completed = false
        ),

        Quest(
            id = 3,
            title = "Functions",
            description = "Build reusable code",
            xpReward = 200,
            unlocked = false,
            completed = false
        )
    )
}