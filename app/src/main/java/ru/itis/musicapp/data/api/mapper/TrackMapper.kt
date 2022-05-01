package ru.itis.musicapp.data.api.mapper

import ru.itis.musicapp.data.api.response.track.TrackResponse
import ru.itis.musicapp.domain.models.Track
import javax.inject.Inject

class TrackMapper @Inject constructor() {

    fun map(response: TrackResponse): Track {
        val track = response.message.body.track
        return Track(
            track.trackId,
            track.commontrackId,
            track.trackName,
            track.artistName,
            track.explicit > 0,
            track.hasLyrics > 0,
        )
    }
}
