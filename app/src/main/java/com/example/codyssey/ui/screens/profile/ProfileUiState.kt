package com.example.codyssey.ui.screens.profile

import com.example.codyssey.model.UserProfile

data class ProfileUiState(

    val isLoading: Boolean = true,

    val profile: UserProfile? = null

)