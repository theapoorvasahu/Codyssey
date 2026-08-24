package com.example.codyssey.ui.screens.lesson

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

@Composable
fun LessonScreen(
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier
) {

    val viewModel: LessonViewModel = viewModel()
    val uiState = viewModel.uiState

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

        items(uiState.lessons) { lesson ->

            Card {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        lesson.title,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Text(
                        lesson.content,
                        modifier = Modifier.padding(top = 8.dp)
                    )

                    Button(
                        onClick = { },
                        modifier = Modifier.padding(top = 12.dp)
                    ) {
                        Text("Start Lesson")
                    }
                }
            }
        }
    }
}