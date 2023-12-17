package com.compose.flyticketsbooking

import android.app.Application
import com.compose.flyticketsbooking.di.AppModule.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin


class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(modules = appModule)
        }
    }
}