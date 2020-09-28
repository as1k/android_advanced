package com.example.movie_db.ui.view_model

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie_db.data.utils.API_KEY
import com.example.movie_db.data.network.ApiClient
import com.example.movie_db.data.model.Movie
import com.example.movie_db.ui.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesListViewModel(context: Context): ViewModel() {

    private val logTag = "MoviesListViewModel"

    private val _state = MutableLiveData<State>()
    val state: LiveData<State> = _state

    private val _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>> = _moviesList

    fun loadMovies() {
        _state.value = State.ShowLoading
        viewModelScope.launch {
            runCatching {
             withContext(Dispatchers.IO) {
                    ApiClient.getApi().getMoviesList(API_KEY)
                }
            }.onSuccess {
                _state.value = State.HideLoading
                _moviesList.value = it.body()?.movies
                _state.value = State.Success
            }.onFailure {
                _state.value = State.HideLoading
                Log.e(logTag, Log.getStackTraceString(it))
            }

        }

    }

}
