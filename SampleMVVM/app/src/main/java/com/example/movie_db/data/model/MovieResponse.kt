package com.example.movie_db.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results") val movies:List<Movie>
)