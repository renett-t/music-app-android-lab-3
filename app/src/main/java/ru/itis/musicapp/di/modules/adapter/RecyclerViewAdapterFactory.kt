package ru.itis.musicapp.di.modules.adapter

import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import ru.itis.musicapp.presentation.rv.TracksAdapter

@AssistedFactory
interface RecyclerViewAdapterFactory {
    fun create(@Assisted("onItemChosenAction") onItemChosenAction: (Int, Int) -> Unit): TracksAdapter
}
