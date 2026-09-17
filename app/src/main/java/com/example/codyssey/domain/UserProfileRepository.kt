package com.example.codyssey.domain

import com.example.codyssey.model.UserProfile

interface UserProfileRepository {

    suspend fun getProfile(): UserProfile

    suspend fun addXp(amount: Int)

    suspend fun recordLessonOpened()
}