package com.example.movie_db.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.movie_db.R
import com.example.movie_db.databinding.ActivityMovieDetailsBinding
import com.example.movie_db.ui.ViewModelProviderFactory
import com.example.movie_db.ui.view_model.MovieDetailsViewModel

class MovieDetailsActivity : AppCompatActivity() {
    
    private lateinit var movieDetailsViewModel: MovieDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bindingImpl: ActivityMovieDetailsBinding = DataBindingUtil
            .setContentView(this, R.layout.activity_movie_details)

        initViewModel()
        bindingImpl.lifecycleOwner = this


        val movieId = intent.getIntExtra("movie_id", 1)

        getMovie(movieId)
        bindingImpl.movie = movieDetailsViewModel.movie.value
    }

    private fun initViewModel() {
        movieDetailsViewModel = ViewModelProvider(this, ViewModelProviderFactory(this))
            .get(MovieDetailsViewModel::class.java)
    }

    private fun getMovie(movieId: Int) {
        movieDetailsViewModel.loadMovie(movieId)
    }
}