package ru.itis.musicapp.data.api.mapper

import ru.itis.musicapp.data.api.response.search.SearchTracksResponse
import ru.itis.musicapp.domain.models.Track
import javax.inject.Inject

class SearchTracksMapper @Inject constructor() {

    fun map(response: SearchTracksResponse): List<Track> {
        val list = ArrayList<Track>()
        for (trackWr in response.message.body.tracks) {
            val track = trackWr.track
            list.add(
                Track(
                    track.trackId,
                    track.commontrackId,
                    track.trackName,
                    track.artistName,
                    track.explicit > 0,
                    track.hasLyrics > 0,
                )
            )
        }
        return list
    }
}
