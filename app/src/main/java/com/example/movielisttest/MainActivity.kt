package com.example.movielisttest

import android.net.wifi.p2p.WifiP2pManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    lateinit var rvMovieList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViiews()
    }

    private fun initViiews() {
        rvMovieList = findViewById(R.id.movie_list)
        rvMovieList.adapter = MovieAdapter(generateDats())
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


        return staggeredGridLayoutManager;
    }

    private fun generateDats(): List<String> {
        return (1..9).map {
            "Star Wars episode $it"
        }
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