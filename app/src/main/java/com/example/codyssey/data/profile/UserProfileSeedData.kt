package com.example.codyssey.data.profile

import com.example.codyssey.model.UserProfile

object UserProfileSeedData {

    val defaultProfile = UserProfile(
        name = "",
        xp = 0,
        streak = 0,
        longestStreak = 0,
        achievementsUnlocked = 0
    )
}