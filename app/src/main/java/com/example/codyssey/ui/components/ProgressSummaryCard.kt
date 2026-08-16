package com.example.codyssey.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.codyssey.ui.theme.CodysseyTheme

@Composable
fun ProgressSummaryCard(
    streak: Int,
    progress: Int,
    currentTrack: String,
    modifier: Modifier = Modifier
){
    ElevatedCard(
        modifier = modifier.fillMaxWidth()
    ){
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.padding(8.dp)
            ){
                Icon(
                    imageVector = Icons.Filled.LocalFireDepartment,
                    contentDescription = "Streak",
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = "$streak Day Streak",
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Spacer(Modifier.height(16.dp))
            Column(modifier = Modifier.padding(8.dp)){
                Text(
                    text = "Roadmap Progress",
                    style = MaterialTheme.typography.labelLarge
                )
                Spacer(Modifier.height(8.dp))
                Row(
                    verticalAlignment =

                        Alignment.CenterVertically
                ){
                    LinearProgressIndicator(
                        progress = { progress / 100f },
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        "$progress%",
                    )
                }
            }
            Spacer(Modifier.height(16.dp))
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = "Current Track",
                    style = MaterialTheme.typography.labelLarge
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = currentTrack,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProgressSummaryCardPreview() {
    CodysseyTheme {
        ProgressSummaryCard(
            streak = 12,
            progress = 34,
            currentTrack = "Android Development"
        )
    }
}