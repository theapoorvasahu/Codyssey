package com.example.codyssey.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codyssey.ui.components.ProgressSummaryCard
import com.example.codyssey.ui.components.QuestCard
import com.example.codyssey.ui.theme.CodysseyTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {

    Scaffold(
        topBar = {


            TopAppBar(
                title = {
                    Text(
                        text = "Codyssey"
                    )
                }
            )

        }
    ) {

            innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)) {

            ProgressSummaryCard(
                streak = 12,
                progress = 34,
                currentTrack = "Android Development"
            )

            Spacer(Modifier.height(16.dp))

            Text(text = "Today's Quest",
                style = MaterialTheme.typography.titleMedium)

            Spacer(Modifier.height(16.dp))

            QuestCard(
                title = "Complete Kotlin Functions",
                description = "Finish today's lesson",
                onContinue = { }
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    CodysseyTheme {
        HomeScreen()
    }
}