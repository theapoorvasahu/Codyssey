package com.example.codyssey.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codyssey.ui.theme.CodysseyTheme

@Composable
fun SettingsSection(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                text = "Settings",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            SettingItem(
                icon = "👤",
                title = "Edit Profile"
            )

            SettingItem(
                icon = "🔔",
                title = "Notifications"
            )

            SettingItem(
                icon = "🌙",
                title = "Dark Mode"
            )

            SettingItem(
                icon = "ℹ️",
                title = "About Codyssey"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsSectionPreview() {
    CodysseyTheme {
        SettingsSection()
    }
}