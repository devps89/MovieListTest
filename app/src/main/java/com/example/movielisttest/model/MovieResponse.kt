package com.example.movielisttest.model

/**
 * in-memory data representation
 * toString()
 * hasCode()
 * equals()
 * componentN()
 * it cannot be inherited
 * it needs a least 1 field/property
 */
data class MovieResponse(
    val title: String,
    val image: String,
    val rating: Float,
    val releaseYear: Int,
    val genre: List<String>
)

class Response:ArrayList<MovieResponse>()