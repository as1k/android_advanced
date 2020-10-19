package com.example.koinexample.network

import com.example.koinexample.model.GithubUser
import retrofit2.Call
import retrofit2.http.GET

interface GithubApi {

    @GET("users")
    fun getUsers(): Call<List<GithubUser>>
}