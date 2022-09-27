package com.fandom.coding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class FigureAdapter : RecyclerView.Adapter<FigureViewHolder>() {
    var listOfFigures: List<NetworkFigure> = emptyList()
    var listOfColors: List<NetworkColor> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FigureViewHolder =
        LayoutInflater.from(parent.context).inflate(R.layout.figure_item, parent, false).let { FigureViewHolder(it) }


    override fun onBindViewHolder(holder: FigureViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.figureName).text = listOfFigures[position].type
        listOfColors.forEach {
            if (it.colorCode == listOfFigures[position].colorCode) {
                holder.itemView.findViewById<TextView>(R.id.color).text = it.color
            }
        }
    }

    override fun getItemCount(): Int = listOfFigures.size
}


class FigureViewHolder(view: View) : ViewHolder(view) {


}