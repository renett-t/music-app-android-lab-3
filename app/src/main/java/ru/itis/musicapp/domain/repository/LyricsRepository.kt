package ru.itis.musicapp.domain.repository

import io.reactivex.rxjava3.core.Single
import ru.itis.musicapp.domain.models.Lyrics

interface LyricsRepository {

    fun getLyricsById(trackId: Int, commontrackId: Int): Single<Lyrics>
}
