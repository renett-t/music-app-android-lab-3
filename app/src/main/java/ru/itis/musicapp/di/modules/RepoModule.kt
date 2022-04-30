package ru.itis.musicapp.di.modules

import dagger.Binds
import dagger.Module
import ru.itis.musicapp.data.repository.LyricsRepositoryImpl
import ru.itis.musicapp.data.repository.TracksRepositoryImpl
import ru.itis.musicapp.domain.repository.LyricsRepository
import ru.itis.musicapp.domain.repository.TracksRepository

@Module
interface RepoModule {
    @Binds
    fun getTracksRepository(repo: TracksRepositoryImpl): TracksRepository

    @Binds
    fun getLyricsRepository(repo: LyricsRepositoryImpl): LyricsRepository
}
