package com.example.cleanarchsample.data.repository

import androidx.lifecycle.LiveData
import com.example.cleanarchsample.data.api.ApiService
import com.example.cleanarchsample.data.model.Item
import com.example.cleanarchsample.domain.RepoListRepository

class RepoListDataStore(apiService: ApiService) : RepoListRepository, BaseDataStore(apiService) {

    override fun loadData(): LiveData<List<Item>> {
        return fetchData { service.getRepo() }
    }
}