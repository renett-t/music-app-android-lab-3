package ru.itis.musicapp.data.api.mapper

import ru.itis.musicapp.data.api.response.lyrics.TrackLyricsResponse
import ru.itis.musicapp.domain.models.Lyrics
import javax.inject.Inject

class TrackLyricsMapper @Inject constructor() {

    fun map(response: TrackLyricsResponse) : Lyrics {

        return Lyrics()
    }
}
