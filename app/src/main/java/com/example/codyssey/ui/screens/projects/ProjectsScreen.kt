package com.example.codyssey.ui.screens.projects

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
import com.example.codyssey.ui.components.ProjectCard
import com.example.codyssey.ui.theme.CodysseyTheme

@Composable
fun ProjectsScreen(
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier
) {

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(
            top = 20.dp,
            bottom = 96.dp
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Projects",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            Text(
                text = "Your Projects",
                style = MaterialTheme.typography.titleLarge
            )
        }

        item {
            ProjectCard(
                title = "Expense Tracker",
                techStack = "Android • Kotlin",
                progress = 0.8f,
                lastUpdated = "2 days ago",
                onContinue = {}
            )
        }

        item {
            ProjectCard(
                title = "Codyssey",
                techStack = "Jetpack Compose • Material 3",
                progress = 0.55f,
                lastUpdated = "Today",
                onContinue = {}
            )
        }

        item {
            ProjectCard(
                title = "Weather App",
                techStack = "Retrofit • Compose",
                progress = 0.2f,
                lastUpdated = "5 days ago",
                onContinue = {}
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProjectScreenPreview() {
    CodysseyTheme {
        ProjectsScreen(
            innerPadding = PaddingValues()
        )
    }
}