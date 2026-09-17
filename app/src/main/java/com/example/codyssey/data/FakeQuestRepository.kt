package com.example.codyssey.data

import com.example.codyssey.model.Quest

object FakeQuestRepository {

    fun getQuests(): List<Quest> {
        return listOf(
            Quest(
                id = 3,
                title = "Build ViewModel",
                description = "Move UI state into ViewModel",
                xpReward = 20,
                unlocked = true
            ),
            Quest(
                id = 4,
                title = "Master State Hoisting",
                description = "Lift state to the parent composable",
                xpReward = 15,
                unlocked = false
            ),
            Quest(
                id = 5,
                title = "Learn Repository Pattern",
                description = "Separate data layer from UI",
                xpReward = 30,
                unlocked = false
            )
        )
    }
}