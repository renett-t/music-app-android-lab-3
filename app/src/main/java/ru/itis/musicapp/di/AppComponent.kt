package ru.itis.musicapp.di

import dagger.BindsInstance
import dagger.Component
import ru.itis.musicapp.di.modules.*
import ru.itis.musicapp.MusicApp

@Component(
    modules = [AppModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun applicationContext(application: MusicApp): Builder
        fun build(): AppComponent
    }

    fun inject(application: MusicApp)

}
