package ru.itis.musicapp

import android.app.Application
import ru.itis.musicapp.di.AppComponent

class MusicApp : Application() {
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }
}
