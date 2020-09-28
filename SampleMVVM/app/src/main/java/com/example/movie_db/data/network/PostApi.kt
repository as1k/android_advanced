package com.example.movie_db.data.network

import com.example.movie_db.data.model.Movie
import com.example.movie_db.data.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PostApi {

    @GET("movie/popular")
    suspend fun getMoviesList(@Query("api_key") apiKey: String): Response<MovieResponse>

    @GET("movie/{movie_id}")
    suspend fun getMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String
    ): Response<Movie>
}