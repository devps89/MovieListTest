package com.example.movielisttest

import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.recyclerview.widget.RecyclerView

class MovieViewHHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    val tvMovieTilte: TextView = view.findViewById(R.id.tv_movie_title)
    val ivMoviePoster: ImageView = view.findViewById(R.id.iv_movie_poster)
    val tvMovieYear: TextView = view.findViewById(R.id.tv_movie_year)
    val tvMovieGenre: TextView = view.findViewById(R.id.tv_movie_genre)
    val rbMovieRating: RatingBar = view.findViewById(R.id.rb_movie_rating)
    val grMovieDetails: Group = view.findViewById(R.id.gr_movie_details)
    val ivShowDetails: ImageView = view.findViewById(R.id.iv_show_details)


}