package ru.itis.musicapp.presentation.extension

import android.content.Context
import ru.itis.musicapp.MusicApp
import ru.itis.musicapp.di.AppComponent

val Context.appComponent : AppComponent
    get() = when (this) {
        is MusicApp -> appComponent
        else -> this.applicationContext.appComponent
    }
