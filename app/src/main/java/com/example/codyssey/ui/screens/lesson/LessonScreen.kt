package com.example.codyssey.ui.screens.lesson

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState

@Composable
fun LessonScreen(
    lessonId: Int,
    lessonViewModel: LessonViewModel,
    innerPadding: PaddingValues,
    onLessonCompleted: () -> Unit,
    modifier: Modifier = Modifier
){

    val uiState = lessonViewModel.uiState.collectAsState().value
    val lesson = uiState.lessons.find { it.id == lessonId }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 20.dp)
    ) {

        item {
            Text(
                text = "Lessons",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
        }

        item {

            lesson?.let {

                Card {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = it.title,
                            style = MaterialTheme.typography.titleLarge
                        )

                        Text(
                            text = it.content,
                            modifier = Modifier.padding(top = 8.dp)
                        )

                        Text(
                            text = "XP Reward: ${it.xpReward}",
                            modifier = Modifier.padding(top = 8.dp)
                        )

                        Button(
                            onClick = {
                                lessonViewModel.completeLesson(it.id)
                                onLessonCompleted()
                            }
                        ) {
                            Text("Complete Lesson")
                        }
                    }
                }
            }
        }
    }
}