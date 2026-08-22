package com.example.codyssey.model

data class Quest(
    val id: Int,
    val title: String,
    val description: String,
    val xpReward: Int,
    val completed: Boolean = false
)