package ru.itis.musicapp

import android.app.Application
import ru.itis.musicapp.di.AppComponent
import ru.itis.musicapp.di.DaggerAppComponent

class MusicApp : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}
