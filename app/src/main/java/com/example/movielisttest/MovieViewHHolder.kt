package com.example.movielisttest

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

class MovieViewHHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    val tvMovieTilte: TextView = view.findViewById(R.id.tv_movie_title)
    val ivMovieImage: ImageView = view.findViewById(R.id.iv_movie_image)

}