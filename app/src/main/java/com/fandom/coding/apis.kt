package com.fandom.coding

import android.os.Looper
import kotlin.random.Random

class ColorApi {
     fun loadColors(): List<NetworkColor> {
         if(Looper.getMainLooper().isCurrentThread){
              throw IllegalStateException("CANNOT ACCESS ON MAIN THREAD")
         }
        return listOf(
            NetworkColor(1, "#FF00FF"),
            NetworkColor(2, "#FF0000"),
            NetworkColor(3, "#0000FF"),
            NetworkColor(4, "#BB00FF")
        )
    }
}


class FigureApi {
    fun loadFigures(): List<NetworkFigure> {
         if(Looper.getMainLooper().isCurrentThread){
              throw IllegalStateException("CANNOT ACCESS ON MAIN THREAD")
         }
        return listOfListOfFigures[Random.nextInt(3)]
    }
}

private const val SQUARE = "square"
private const val TRIANGLE = "triangle"
private const val RECTANGLE = "rectangle"
private const val DIAMOND = "diamond"

private  val listOfListOfFigures = listOf(
    listOf(
        NetworkFigure(type = SQUARE, colorCode = 1, 1),
        NetworkFigure(type = SQUARE, colorCode = 2, 2),
        NetworkFigure(type = TRIANGLE, colorCode = 2, 3),
        NetworkFigure(type = DIAMOND, colorCode = 3, 4),
        NetworkFigure(type = RECTANGLE, colorCode = 4, 5),
        NetworkFigure(type = TRIANGLE, colorCode = 4, 6)
    ),
    listOf(
        NetworkFigure(type = SQUARE, colorCode = 1, 3),
        NetworkFigure(type = SQUARE, colorCode = 1, 2),
        NetworkFigure(type = TRIANGLE, colorCode = 3, 1),
        NetworkFigure(type = DIAMOND, colorCode = 3, 4),
        NetworkFigure(type = RECTANGLE, colorCode = 2, 6),
        NetworkFigure(type = TRIANGLE, colorCode = 4, 5),
    ),
    listOf(
        NetworkFigure(type = TRIANGLE, colorCode = 1, 1),
        NetworkFigure(type = SQUARE, colorCode = 2, 4),
        NetworkFigure(type = TRIANGLE, colorCode = 2, 5),
        NetworkFigure(type = DIAMOND, colorCode = 3, 2),
        NetworkFigure(type = RECTANGLE, colorCode = 4, 3),
        NetworkFigure(type = DIAMOND, colorCode = 4, 6),
    )
)
