package com.example.codyssey.ui.screens.journey

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codyssey.model.LessonState
import com.example.codyssey.ui.components.RoadmapNode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import com.example.codyssey.model.Lesson
import com.example.codyssey.ui.theme.CodysseyTheme
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.layout.positionInWindow
import com.example.codyssey.ui.components.JourneyPath

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JourneyScreen(modifier: Modifier = Modifier) {
    val lessons = listOf(
        Lesson("Variables", LessonState.Completed),
        Lesson("Functions", LessonState.Completed),
        Lesson("OOP", LessonState.Current),
        Lesson("Collections", LessonState.Locked),
        Lesson("Coroutines", LessonState.Locked)
    )

    val nodeCenters = remember {
        mutableStateListOf<Offset>()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Journey")
                },
                actions = {
                    Text("⭐620 XP")
                }
            )

        }
    ){
            innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()

        ){
            JourneyPath(
                modifier = Modifier.fillMaxSize(),
                nodeCenters = nodeCenters,
                nodeRadius = 48f
            )

            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                itemsIndexed(lessons) { index, lesson ->

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(innerPadding),
                        contentAlignment =
                            if (index % 2 == 0)
                                Alignment.CenterStart
                            else
                                Alignment.CenterEnd
                    ) {

                        RoadmapNode(
                            modifier = Modifier.onGloballyPositioned { coordinates ->
                                val position = coordinates.positionInRoot()
                                val size = coordinates.size

                                val center = Offset(
                                    x = position.x + size.width / 2f,
                                    y = position.y + size.height / 2f
                                )
                                if(index < nodeCenters.size){
                                    nodeCenters[index] = center
                                }
                                else{
                                    nodeCenters.add(center)
                                }
                            },
                            title = lesson.title,
                            state = lesson.state,
                            onClick = { }
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun JourneyScreenPreview() {
    CodysseyTheme {
        JourneyScreen()
    }
}