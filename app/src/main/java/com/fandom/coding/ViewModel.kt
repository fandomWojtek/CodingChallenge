package com.fandom.coding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FiguresViewModel: ViewModel() {
    private val figureApi = FigureApi()
    private val colorApi = ColorApi()

    val figuresStream = MutableLiveData<List<NetworkFigure>>()
    val colorStream = MutableLiveData<List<NetworkColor>>()

    fun load(){
        Thread {
            val figures = figureApi.loadFigures()
            figuresStream.postValue(figures)
            val colors = colorApi.loadColors()
            colorStream.postValue(colors)
        }.start()
    }
}


class FigureViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(FiguresViewModel::class.java)) {
            FiguresViewModel() as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
