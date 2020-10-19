package com.example.koinexample

import android.app.Application
import com.example.koinexample.di.apiModule
import com.example.koinexample.di.repositoryModule
import com.example.koinexample.di.retrofitModule
import com.example.koinexample.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(repositoryModule, viewModelModule, retrofitModule, apiModule))
        }
    }
}