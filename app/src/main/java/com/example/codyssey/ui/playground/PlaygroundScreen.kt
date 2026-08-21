package com.example.codyssey.ui.playground

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PlaygroundScreen() {

    val viewModel: PlaygroundViewModel = viewModel()

    val uiState = viewModel.uiState

    LayoutPlayground(
        xp = uiState.xp,
        streak = uiState.streak,
        lessons = uiState.lessons,

        onAddXp = viewModel::addXp,
        onCompleteLesson = viewModel::completeLesson,
        onReset = viewModel::reset
    )
}