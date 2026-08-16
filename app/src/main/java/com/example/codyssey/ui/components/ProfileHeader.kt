package com.example.codyssey.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codyssey.model.LessonState
import com.example.codyssey.ui.theme.CodysseyTheme

@Composable
fun ProfileHeader(
    name: String,
    level: Int,
    xp: Int,
    nextLevelXp: Int,
    streak: Int,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(112.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = name.first().toString(),
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
        Text(
            text = name,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Android Explorer • Lv. $level",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = "\uD83D\uDD25 $streak Day Streak",
            style = MaterialTheme.typography.bodyMedium
        )

        LinearProgressIndicator(
            progress = { xp.toFloat() / nextLevelXp },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .height(8.dp)
        )
        Text(
            text = "$xp / $nextLevelXp XP",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

    }
}

@Preview(showBackground = true)
@Composable
fun ProfileHeaderPreview() {
    CodysseyTheme {
        ProfileHeader(
            name = "Apoorva Sahu",
            level = 3,
            xp = 600,
            nextLevelXp = 1000,
            streak = 12
        )
    }
}