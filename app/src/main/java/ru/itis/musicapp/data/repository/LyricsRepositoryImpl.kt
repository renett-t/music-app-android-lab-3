package ru.itis.musicapp.data.repository

import io.reactivex.rxjava3.core.Single
import ru.itis.musicapp.data.api.MusixMatchApi
import ru.itis.musicapp.data.api.mapper.TrackLyricsMapper
import ru.itis.musicapp.domain.models.Lyrics
import ru.itis.musicapp.domain.repository.LyricsRepository
import javax.inject.Inject

class LyricsRepositoryImpl @Inject constructor(
    private val api: MusixMatchApi,
    private val mapper: TrackLyricsMapper
): LyricsRepository {

    override fun getLyricsById(trackId: Int, commontrackId: Int): Single<Lyrics> =
        api.getTrackLyrics(trackId, commontrackId)
            .map {
                mapper.map(it)
            }
}
