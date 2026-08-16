package com.example.codyssey.ui.screens.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.codyssey.ui.components.AchievementCard
import com.example.codyssey.ui.components.MonthlyBadgeCard
import com.example.codyssey.ui.components.ProfileHeader
import com.example.codyssey.ui.components.RecentActivitySection
import com.example.codyssey.ui.components.SettingsSection
import com.example.codyssey.ui.components.StatCard
import com.example.codyssey.ui.theme.CodysseyTheme
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile") }
            )
        }
    ){ innerPadding ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            item {
                ProfileHeader(
                    name = "Apoorva Sahu",
                    level = 3,
                    xp = 600,
                    nextLevelXp = 1000,
                    streak = 12
                )
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    StatCard(
                        modifier = Modifier.weight(1f),
                        title = "Lessons",
                        value = "28"
                    )

                    StatCard(
                        modifier = Modifier.weight(1f),
                        title = "XP",
                        value = "600"
                    )
                }
            }

            item {
                StatCard(
                    modifier = Modifier.fillMaxWidth(),
                    title = "Achievements",
                    value = "14"
                )
            }

            item {
                RecentActivitySection(
                    activities = listOf(
                        "✅ Completed Variables",
                        "⭐ Earned 50 XP",
                        "🏆 Unlocked First Steps"
                    )
                )
            }

            item {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Monthly Badges",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        item {
                            MonthlyBadgeCard(
                                title = "Spring Bloom",
                                month = "April 2026",
                                emoji = "🌸",
                                unlocked = true
                            )
                        }

                        item {
                            MonthlyBadgeCard(
                                title = "Spring Bloom",
                                month = "April 2026",
                                emoji = "🌸",
                                unlocked = true
                            )
                        }

                        item {
                            MonthlyBadgeCard(
                                title = "Spring Bloom",
                                month = "April 2026",
                                emoji = "🌸",
                                unlocked = true
                            )
                        }
                    }
                }
            }

            item {
                Text(
                    text = "Achievements",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    AchievementCard(
                        title = "First Steps",
                        description = "Complete your first lesson",
                        unlocked = true
                    )
                    AchievementCard(
                        title = "First Steps",
                        description = "Complete your first lesson",
                        unlocked = true
                    )
                    AchievementCard(
                        title = "First Steps",
                        description = "Complete your first lesson",
                        unlocked = true
                    )
                }
            }

            item {
                Spacer(Modifier.height(8.dp))
                SettingsSection()
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    CodysseyTheme {
        ProfileScreen()
    }
}