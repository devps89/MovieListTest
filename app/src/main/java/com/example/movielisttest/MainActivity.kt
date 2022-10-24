package com.example.movielisttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.movielisttest.model.MovieResponse
import com.example.movielisttest.model.remote.MovieNetwork
import com.squareup.picasso.Picasso

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    lateinit var rvMovieList: RecyclerView


    //we configure the handler to wait for he message from the thread
    private val movieHandler =
        object : Handler() {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                when (msg.what) {
                    1 -> {
                        val listOfMovies: List<MovieResponse> =
                            msg.obj as List<MovieResponse>
                        Log.d(TAG, "handleMessage: $listOfMovies")
                        rvMovieList.adapter = MovieAdapter(listOfMovies)
                    }
                    else -> {
                        msg.data?.getString("KEY")?.let {
                            Toast.makeText(
                                this@MainActivity,
                                it, Toast.LENGTH_SHORT
                            ).show()
                        }
                    }


                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate: main  ${Thread.currentThread().name}")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViiews()
        getMovieList()
//        rvMovieList.adapter = MovieAdapter(getMovieListNoThread())
    }

    private fun initViiews() {
        rvMovieList = findViewById(R.id.movie_list)
        //rvMovieList.adapter = MovieAdapter(getMovieList())
        rvMovieList.layoutManager = createLayoutMannager()
    }

    private fun createLayoutMannager(): RecyclerView.LayoutManager {
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        val gridLayoutManager = GridLayoutManager(this, 3, GridLayoutManager.HORIZONTAL, false)

        //in this is non necessary the context because  it has other option without it
        val staggeredGridLayoutManager =
            StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL)


        return linearLayoutManager;
    }

    private fun getMovieListNoThread(): List<MovieResponse> = MovieNetwork().getMovieList()


    private fun getMovieList() {
        val network = MovieNetwork()
        Thread(Runnable {
            Log.d(TAG, "getMovieList1: ${Thread.currentThread().name}")
            val message = Message()
            message.what = 1
            Log.d(TAG, "getMovieList: llamar a getMovieList")
            message.obj = network.getMovieList()
            Log.d(TAG, "getMovieList: lista obtenida")
            movieHandler.sendMessage(message)//here we are linking the handler with the thread, with the message
//            network.getMovieList()
        }).start()


        Thread(Runnable {
            Log.d(TAG, "getMovieList2:  ${Thread.currentThread().name}")
            movieHandler.sendMessage(
                Message().apply {
                    data = Bundle().apply {
                        what = 2
                        putString("KEY", "${Thread.currentThread().name}")
                    }
                }
            )
        }).start()

//        return ex.call()
    }
}

/*
1.- Create a Item_Layout (layout xml file)
2.- Subclass of RecyclerView.ViewHolder
3.- Subclass of RecyclerView.Adapter
4.- Configure the movielist view
    4.a.- setAdapter
    4.b.- setLayoutManager
 */