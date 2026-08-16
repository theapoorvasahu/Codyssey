package com.example.codyssey.ui.shapes

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class HexagonShape : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path()
        path.moveTo(
            x = size.width / 2f,
            y = 0f
        )

        path.lineTo(
            x = size.width,
            y = size.height * 0.25f
        )

        path.lineTo(
            x = size.width,
            y = size.height * 0.75f
        )

        path.lineTo(
            x = size.width * 0.5f,
            y = size.height
        )

        path.lineTo(
            x = 0f,
            y = size.height * 0.75f
        )

        path.lineTo(
            x = 0f,
            y = size.height * 0.25f
        )

        path.close()

        return Outline.Generic(path)
    }

}