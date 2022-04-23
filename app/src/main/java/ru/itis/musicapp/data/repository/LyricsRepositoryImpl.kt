package ru.itis.musicapp.data.repository

import io.reactivex.rxjava3.core.Single
import ru.itis.musicapp.domain.models.Lyrics
import ru.itis.musicapp.domain.repository.LyricsRepository
import javax.inject.Inject

class LyricsRepositoryImpl @Inject constructor(

): LyricsRepository {
    override fun getLyricsById(trackId: Int, commontrackId: Int): Single<Lyrics> {
        TODO("Not yet implemented")
    }
}
