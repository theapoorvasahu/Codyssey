package com.example.codyssey.data.profile

import com.example.codyssey.model.UserProfile

fun UserProfileEntity.toDomain() = UserProfile(
    name = name,
    xp = xp,
    streak = streak,
    longestStreak = longestStreak,
    achievementsUnlocked = achievementsUnlocked
)

fun UserProfile.toEntity() = UserProfileEntity(
    id = 1,
    name = name,
    xp = xp,
    streak = streak,
    longestStreak = longestStreak,
    achievementsUnlocked = achievementsUnlocked
)