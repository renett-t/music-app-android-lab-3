package ru.itis.musicapp.di

import dagger.BindsInstance
import dagger.Component
import ru.itis.musicapp.di.modules.*
import ru.itis.musicapp.MusicApp
import ru.itis.musicapp.presentation.fragments.DetailsFragment
import ru.itis.musicapp.presentation.fragments.ListFragment

@Component(
    modules = [AppModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: MusicApp): Builder
        fun build(): AppComponent
    }

    fun inject(application: MusicApp)
    fun inject(listFragment: ListFragment)
    fun inject(detailsFragment: DetailsFragment)
}
