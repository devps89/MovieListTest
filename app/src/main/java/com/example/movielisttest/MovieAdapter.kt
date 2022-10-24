package com.example.movielisttest

import android.R.attr.src
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movielisttest.model.MovieResponse
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


private const val TAG = "MovieAdapter"

class MovieAdapter(private val MovieList: List<MovieResponse>) :
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
        if (position % 2 == 0) {

            holder.itemView.setBackgroundColor(Color.CYAN)
            //holder.itemView.setTextColor(Color.parseColor("#000000"));

        }
        var movieimg: String? = MovieList[position].image
        Log.d(TAG, "onBindViewHolder: $movieimg")
        Picasso.get()
            .load(movieimg)
            .networkPolicy(NetworkPolicy.NO_CACHE) //for caching the image url in case phone is offline
            .placeholder(R.drawable.movie_prev_img)//it will show placeholder image when url is not valid.

            .into(holder.ivMovieImage)

//        val `in` = java.net.URL(movieimg).openStream()
//        var image: Bitmap?  = BitmapFactory.decodeStream(`in`)

        // Only for making changes in UI
       // holder.ivMovieImage.setImageBitmap(image)

        //holder.ivMovieImage.setImageBitmap(myBitmap)
        holder.tvMovieTilte.text = MovieList[position].title
    }

    override fun getItemCount(): Int {
        return MovieList.size
    }
}