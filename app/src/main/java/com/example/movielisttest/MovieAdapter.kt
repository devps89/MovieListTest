package com.example.movielisttest

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val MovieList: List<String>) : RecyclerView.Adapter<MovieViewHHolder>() {

    /**
     * Used to create the ViewHolder.
     * This will be called only once.
     * if the structure of the ViewHolder changes, this one
     * will be called again.
     * Get KLayoutInflater.from(context)
     * Context needs to FROM
     * Base context(ContextThemesWrap[per)
     * base context provides Themes, Resources and
     * the InnFLater.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHHolder {
        return MovieViewHHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.movie_item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHHolder, position: Int) {
        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(Color.BLUE)
        }
        holder.tvMovieTilte.text = MovieList[position]
    }

    override fun getItemCount(): Int {
        return MovieList.size
    }
}