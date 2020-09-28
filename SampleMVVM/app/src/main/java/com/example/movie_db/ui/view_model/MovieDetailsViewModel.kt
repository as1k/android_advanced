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

class MovieDetailsViewModel(context: Context) :ViewModel() {

    private val logTag = "MovieDetailsViewModel"

    private val _state = MutableLiveData<State>()
    val state: LiveData<State> = _state

    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> = _movie

    fun loadMovie(id: Int) {
        _state.value = State.ShowLoading
        viewModelScope.launch {
            runCatching {
                withContext(Dispatchers.IO) {
                    ApiClient.getApi().getMovie(movieId = id, apiKey = API_KEY)
                }
            }.onSuccess {
                _state.value = State.HideLoading
                _movie.value = it.body()
                _state.value = State.Success
            }.onFailure {
                _state.value = State.HideLoading
                Log.e(logTag, Log.getStackTraceString(it))
            }

        }

    }
}