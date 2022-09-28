package com.fandom.coding

import android.os.Looper
import kotlin.random.Random

class ColorApi {
    fun loadColors(): List<NetworkColor> {
        if (Looper.getMainLooper().isCurrentThread) {
            throw IllegalStateException("CANNOT ACCESS ON MAIN THREAD")
        }
        return listOf(
            NetworkColor(colorCode = 1, color = "#FF00FF"),
            NetworkColor(colorCode = 2, color = "#FF0000"),
            NetworkColor(colorCode = 3, color = "#0000FF"),
            NetworkColor(colorCode = 4, color = "#BB00FF")
        )
    }
}


class FigureApi {
    fun loadFigures(): List<NetworkFigure> {
        if (Looper.getMainLooper().isCurrentThread) {
            throw IllegalStateException("CANNOT ACCESS ON MAIN THREAD")
        }
        return listOfListOfFigures[Random.nextInt(3)]
    }
}

private const val SQUARE = "square"
private const val TRIANGLE = "triangle"
private const val RECTANGLE = "rectangle"
private const val DIAMOND = "diamond"

private val listOfListOfFigures = listOf(
    listOf(
        NetworkFigure(type = SQUARE, colorCode = 1, id = 1),
        NetworkFigure(type = SQUARE, colorCode = 2, id = 2),
        NetworkFigure(type = TRIANGLE, colorCode = 2, id = 3),
        NetworkFigure(type = DIAMOND, colorCode = 3, id = 4),
        NetworkFigure(type = RECTANGLE, colorCode = 4, id = 5),
        NetworkFigure(type = TRIANGLE, colorCode = 4, id = 6)
    ),
    listOf(
        NetworkFigure(type = SQUARE, colorCode = 1, id = 3),
        NetworkFigure(type = SQUARE, colorCode = 1, id = 2),
        NetworkFigure(type = TRIANGLE, colorCode = 3, id = 1),
        NetworkFigure(type = DIAMOND, colorCode = 3, id = 4),
        NetworkFigure(type = RECTANGLE, colorCode = 2, id = 6),
        NetworkFigure(type = TRIANGLE, colorCode = 4, id = 5),
    ),
    listOf(
        NetworkFigure(type = TRIANGLE, colorCode = 1, id = 1),
        NetworkFigure(type = SQUARE, colorCode = 2, id = 4),
        NetworkFigure(type = TRIANGLE, colorCode = 2, id = 5),
        NetworkFigure(type = DIAMOND, colorCode = 3, id = 2),
        NetworkFigure(type = RECTANGLE, colorCode = 4, id = 3),
        NetworkFigure(type = DIAMOND, colorCode = 4, id = 6),
    )
)
