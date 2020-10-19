package com.example.koinexample.repository

import com.example.koinexample.network.GithubApi

class UserRepository(private val api: GithubApi) {
    fun getAllUsers() = api.getUsers()
}