package com.example.codyssey.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import com.example.codyssey.ui.theme.CodysseyTheme
import androidx.compose.ui.graphics.PathEffect

private const val CONTROL_POINT = 0.20f
private const val CURVE_FACTOR = 0.18f
private const val MIN_CURVE = 25f
private const val MAX_CURVE = 70f
private const val PATH_WIDTH = 8f

@Composable
fun JourneyPath(
    nodeCenters: List<Offset>,
    nodeRadius: Float,
    modifier: Modifier = Modifier
) {
    val glowColor = MaterialTheme.colorScheme.primary
    Canvas(modifier = modifier) {



        if (nodeCenters.size < 2) return@Canvas

        for (i in 0 until nodeCenters.lastIndex) {

            val start = nodeCenters[i]
            val end = nodeCenters[i + 1]

            val path = createConnectorPath(
                start = start,
                end = end,
                nodeRadius = nodeRadius
            )

            drawPath(
                path = path,
                color = glowColor,
                alpha = 0.20f,
                style = Stroke(
                    width = PATH_WIDTH * 2f,
                    cap = StrokeCap.Round,
                    join = StrokeJoin.Round
                )
            )

            drawPath(
                path = path,
                color = Color(0xFF8C8C8C),
                style = Stroke(
                    width = PATH_WIDTH,
                    cap = StrokeCap.Round,
                    join = StrokeJoin.Round,

                )
            )
        }
    }
}
private fun createConnectorPath(
    start: Offset,
    end: Offset,
    nodeRadius: Float
): Path {

    val direction = end - start
    val distance = direction.getDistance()

    if (distance == 0f) return Path()

    val unit = direction / distance

    val startPoint = start + unit * nodeRadius
    val endPoint = end - unit * nodeRadius

    val perpendicular = Offset(
        -unit.y,
        unit.x
    )

    val curveAmount =
        (distance * CURVE_FACTOR)
            .coerceIn(MIN_CURVE, MAX_CURVE)

    val segment = endPoint - startPoint

    val control1 =
        startPoint +
                segment * CONTROL_POINT +
                perpendicular * curveAmount

    val control2 =
        endPoint -
                segment * CONTROL_POINT

    return Path().apply {
        moveTo(startPoint.x, startPoint.y)
        cubicTo(
            control1.x,
            control1.y,
            control2.x,
            control2.y,
            endPoint.x,
            endPoint.y
        )
    }
}

@Preview(showBackground = true)
@Composable
fun JourneyPathPreview() {
    CodysseyTheme {
        JourneyPath(
            nodeCenters = listOf(
                Offset(100f, 200f),
                Offset(300f, 400f)
            ),
            nodeRadius = 48f
        )
    }
}