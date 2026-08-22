package com.example.codyssey.data

import com.example.codyssey.model.Quest

object FakeQuestRepository {

    private val quests = listOf(

        Quest(
            id = 1,
            title = "Complete Kotlin Functions",
            description = "Finish today's lesson",
            xpReward = 10
        ),

        Quest(
            id = 2,
            title = "Learn State",
            description = "Understand remember and mutableStateOf",
            xpReward = 20
        )

    )
    fun getTodaysQuest(): Quest {
        return quests.first()
    }
}