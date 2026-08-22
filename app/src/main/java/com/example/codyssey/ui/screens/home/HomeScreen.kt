package com.example.codyssey.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.codyssey.ui.components.ProgressSummaryCard
import com.example.codyssey.ui.components.QuestCard
import com.example.codyssey.ui.theme.CodysseyTheme


@Composable
fun HomeScreen(
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier
) {

    val viewModel: HomeViewModel = viewModel()
    val uiState = viewModel.uiState

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(
            top = 20.dp,
            bottom = 20.dp
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Home",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
        }
        item {
            ProgressSummaryCard(
                streak = uiState.streak,
                progress = uiState.progress,
                currentTrack = uiState.currentTrack
            )
        }
        item{
            Text(text = "Today's Quest",
                style = MaterialTheme.typography.titleLarge)
        }
        item{
            uiState.quest?.let { quest ->

                QuestCard(
                    title = quest.title,
                    description = quest.description,
                    onContinue = {
                        viewModel.completeLesson()
                    }
                )

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    CodysseyTheme {
        HomeScreen(
            innerPadding = PaddingValues()
        )
    }
}