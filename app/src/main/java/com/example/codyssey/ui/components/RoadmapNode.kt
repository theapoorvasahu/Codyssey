package com.example.codyssey.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codyssey.model.LessonState
import com.example.codyssey.ui.shapes.HexagonShape
import com.example.codyssey.ui.theme.CodysseyTheme

@Composable
fun RoadmapNode(
    title: String,
    state: LessonState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    val icon = when(state) {

        LessonState.Completed ->  Icons.Filled.Check

        LessonState.Current ->  Icons.Filled.Code

        LessonState.Locked ->  Icons.Filled.Lock

    }

    val containerColor  = when(state) {

        LessonState.Completed -> MaterialTheme.colorScheme.primary

        LessonState.Current -> MaterialTheme.colorScheme.primary

        LessonState.Locked -> MaterialTheme.colorScheme.outline

    }

    val tonalElevation   = when(state) {

        LessonState.Completed -> 4.dp

        LessonState.Current -> 8.dp

        LessonState.Locked -> 0.dp

    }

    val contentColor = when(state) {
        LessonState.Completed -> MaterialTheme.colorScheme.onPrimary

        LessonState.Current -> MaterialTheme.colorScheme.onPrimary

        LessonState.Locked -> MaterialTheme.colorScheme.onSurfaceVariant

    }

    Surface(
        tonalElevation = tonalElevation,
        contentColor = contentColor,
        color = containerColor,
        shape = HexagonShape(),
        onClick = onClick,
        modifier = modifier
            .shadow(
                elevation = if (state == LessonState.Current) 12.dp else 0.dp,
                shape = HexagonShape(),
                clip = false
            )
            .size(104.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = title,
                style = MaterialTheme.typography.labelLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CurrentRoadmapNodePreview() {
    CodysseyTheme {
        RoadmapNode(
            title = "Functions",
            state = LessonState.Current,
            onClick = { }
        )
    }
}