package com.example.codyssey.data.quest

import com.example.codyssey.model.Quest

fun QuestEntity.toQuest() = Quest(
    id = id,
    title = title,
    description = description,
    xpReward = xpReward,
    unlocked = unlocked,
    completed = completed
)

fun Quest.toEntity() = QuestEntity(
    id = id,
    title = title,
    description = description,
    xpReward = xpReward,
    unlocked = unlocked,
    completed = completed
)