package com.leonamleite.marvelapi

import android.app.Application
import com.leonamleite.marvelapi.data.di.DataModule
import com.leonamleite.marvelapi.data.di.DomainModule
import com.leonamleite.marvelapi.data.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModule.load()
        DomainModule.load()
        ViewModelModule.load()
    }
}