package com.example.movie_db.ui

sealed class State {
    object ShowLoading : State()
    object HideLoading : State()
    object Success : State()
}
