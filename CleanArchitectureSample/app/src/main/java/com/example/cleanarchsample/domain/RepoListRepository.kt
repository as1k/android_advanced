package com.example.cleanarchsample.domain

import androidx.lifecycle.LiveData
import com.example.cleanarchsample.data.model.Item

interface RepoListRepository {
    fun loadData(): LiveData<List<Item>>
}