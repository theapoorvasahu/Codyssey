package com.example.codyssey.domain

import com.example.codyssey.model.Quest

interface QuestRepository {

    suspend fun getQuests(): List<Quest>

    suspend fun getQuest(id: Int): Quest?

    suspend fun unlockQuest(id: Int)

    suspend fun completeQuest(id: Int)
}