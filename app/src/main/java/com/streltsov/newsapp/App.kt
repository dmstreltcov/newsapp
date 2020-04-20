package com.streltsov.newsapp

import android.app.Application
import android.content.Context
import android.util.Log
import com.streltsov.newsapp.di.AppComponent
import com.streltsov.newsapp.di.DaggerAppComponent
import com.streltsov.newsapp.di.modules.AppModule

class App : Application() {

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("App", "${instance} initialized")

    }

    companion object {
        private lateinit var instance: App

        fun applicationContext(): Context {
            return instance.applicationContext
        }

        fun appComponent(): AppComponent {
            return DaggerAppComponent
                .builder()
                .build()
        }
    }

}