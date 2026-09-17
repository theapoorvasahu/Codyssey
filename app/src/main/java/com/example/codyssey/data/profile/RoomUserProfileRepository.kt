package com.example.codyssey.data.profile


import com.example.codyssey.domain.UserProfileRepository
import com.example.codyssey.model.UserProfile
import javax.inject.Inject

class RoomUserProfileRepository @Inject constructor(
    private val userProfileDao: UserProfileDao
) : UserProfileRepository {

    override suspend fun getProfile(): UserProfile {
        seedProfileIfNeeded()

        val profile = userProfileDao.getProfile()!!

        return profile.toDomain()
    }

    override suspend fun addXp(amount: Int) {

        val profile = userProfileDao.getProfile() ?: return

        val updatedProfile = profile.copy(
            xp = profile.xp + amount
        )

        userProfileDao.updateProfile(updatedProfile)
    }

    override suspend fun recordLessonOpened() {

        val profile = userProfileDao.getProfile() ?: return

        val updatedProfile = profile.copy(
            streak = profile.streak + 1,
            longestStreak = maxOf(
                profile.longestStreak,
                profile.streak + 1
            )
        )

        userProfileDao.updateProfile(updatedProfile)
    }
    private suspend fun seedProfileIfNeeded() {
        if (userProfileDao.getProfile() == null) {
            userProfileDao.insertProfile(
                UserProfileSeedData.defaultProfile.toEntity()
            )
        }
    }
}