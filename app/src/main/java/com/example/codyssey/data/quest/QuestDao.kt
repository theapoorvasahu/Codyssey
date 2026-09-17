package com.example.codyssey.data.quest

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface QuestDao {

    @Query("SELECT * FROM quests")
    suspend fun getQuests(): List<QuestEntity>

    @Query("SELECT * FROM quests WHERE id = :id")
    suspend fun getQuest(id: Int): QuestEntity?

    @Update
    suspend fun updateQuest(
        quest: QuestEntity
    )

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertQuests(
        quests: List<QuestEntity>
    )

    @Query("SELECT COUNT(*) FROM quests")
    suspend fun getQuestCount(): Int
}