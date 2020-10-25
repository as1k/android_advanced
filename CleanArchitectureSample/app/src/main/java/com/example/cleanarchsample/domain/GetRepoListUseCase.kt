package com.example.cleanarchsample.domain

import androidx.lifecycle.LiveData
import com.example.cleanarchsample.data.model.Item

class GetRepoListUseCase(val repoListRepository: RepoListRepository) {
    fun getRepoList(): LiveData<List<Item>> {
        return repoListRepository.loadData()
    }
}