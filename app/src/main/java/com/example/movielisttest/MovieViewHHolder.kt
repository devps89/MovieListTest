package com.example.movielisttest

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieViewHHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    val tvMovieTilte: TextView = view.findViewById(R.id.tv_movie_title)

}