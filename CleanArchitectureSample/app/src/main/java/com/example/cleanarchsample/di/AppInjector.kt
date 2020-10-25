package com.example.cleanarchsample.di

import android.content.SharedPreferences
import com.example.cleanarchsample.data.api.ApiClient
import com.example.cleanarchsample.data.repository.RepoListDataStore
import com.example.cleanarchsample.domain.GetRepoListUseCase
import com.example.cleanarchsample.viewmodel.RepoListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { RepoListViewModel(get()) }
}

val useCaseModule = module {
    single { GetRepoListUseCase(get<RepoListDataStore>()) }
}

val repositoryModule = module {
    single { RepoListDataStore(get()) }
}

val networkModule = module {
    single { ApiClient.create(okHttpClient = get()) }
    single { ApiClient.getOkHttpClient(authInterceptor = get()) }
    single { ApiClient.getAuthInterceptor(sharedPreferences = get()) }
}


val sharedPrefModule = module {
    single {
        androidApplication().getSharedPreferences("default", android.content.Context.MODE_PRIVATE)
    }

    single<SharedPreferences.Editor> {
        androidApplication().getSharedPreferences("default", android.content.Context.MODE_PRIVATE)
            .edit()
    }
}