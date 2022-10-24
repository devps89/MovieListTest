package com.example.movielisttest

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movielisttest.model.MovieResponse
import com.squareup.picasso3.Picasso

private const val TAG = "MovieAdapter"
class MovieAdapter(private val dataset: List<MovieResponse>) :
    RecyclerView.Adapter<MovieViewHHolder>() {

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
        Log.d(TAG, "onBindViewHolder: ")
        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(Color.BLUE)
        }
        holder.tvMovieTilte.text = dataset[position].title
        holder.tvMovieYear.text = dataset[position].releaseYear.toString()
        holder.tvMovieGenre.text = dataset[position].genre.toString()
        holder.rbMovieRating.rating = dataset[position].rating
        holder.rbMovieRating.numStars = 5

        holder.ivShowDetails.setOnClickListener { holder.grMovieDetails.visibility = View.VISIBLE }
        Picasso.Builder(holder.itemView.context)
            .build().load(dataset[position].image)
            .into(holder.ivMoviePoster)


    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}