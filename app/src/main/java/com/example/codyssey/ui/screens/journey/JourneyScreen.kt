package com.example.codyssey.ui.screens.journey

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.codyssey.model.LessonState
import com.example.codyssey.ui.components.JourneyPath
import com.example.codyssey.ui.components.RoadmapNode
import com.example.codyssey.ui.screens.lesson.LessonViewModel
import com.example.codyssey.ui.theme.CodysseyTheme
import com.example.codyssey.ui.navigation.Screen
import androidx.compose.runtime.collectAsState

@Composable
fun JourneyScreen(
    navController: NavHostController,
    lessonViewModel: LessonViewModel,
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier
){


    val uiState = lessonViewModel.uiState.collectAsState().value

    val nodeCenters = remember {
        mutableStateListOf<Offset>()
    }



    Box(
        modifier = modifier
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
                .padding(16.dp),
            contentPadding = PaddingValues(
                top = 20.dp,
                bottom = 20.dp
            ),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {

            item {
                Text(
                    text = "Journey",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold
                )
            }

            itemsIndexed(uiState.lessons) { index, lesson ->

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
                        onClick = {
                            if (lesson.state == LessonState.Current) {
                                navController.navigate(
                                    Screen.Lesson.createRoute(lesson.id)
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun JourneyScreenPreview() {
    CodysseyTheme {
        val navController = rememberNavController()
        val lessonViewModel: LessonViewModel = viewModel()
        JourneyScreen(
            navController = navController,
            lessonViewModel = lessonViewModel,
            innerPadding = PaddingValues()
        )
    }
}