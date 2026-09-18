package com.example.codyssey.data.quest

import com.example.codyssey.domain.QuestRepository
import com.example.codyssey.model.Quest
import jakarta.inject.Inject


class RoomQuestRepository @Inject constructor(
    private val questDao: QuestDao
) : QuestRepository {
    override suspend fun getQuests(): List<Quest> {

        seedDatabaseIfNeeded()

        return questDao
            .getQuests()
            .map { it.toQuest() }
    }

    override suspend fun unlockQuest(id: Int) {

        val quest = questDao.getQuest(id) ?: return

        if (quest.unlocked) return

        questDao.updateQuest(
            quest.copy(unlocked = true)
        )
    }
    private suspend fun seedDatabaseIfNeeded() {

        if (questDao.getQuestCount() == 0) {
            questDao.insertQuests(
                QuestSeedData.defaultQuests.map { it.toEntity() }
            )
        }
    }

    override suspend fun completeQuest(id: Int) {

        val quest = questDao.getQuest(id) ?: return

        val updatedQuest = quest.copy(
            completed = true
        )

        questDao.updateQuest(updatedQuest)
    }

    override suspend fun getQuest(id: Int): Quest? {
        return questDao.getQuest(id)?.toQuest()
    }
}