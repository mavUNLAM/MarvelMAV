package com.unlam.marvel

import android.app.Application
import com.unlam.marvel.di.networkModule
import com.unlam.marvel.di.repositoryModule
import com.unlam.marvel.di.viewmodelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(networkModule, repositoryModule, viewmodelModule)
        }
    }
}
