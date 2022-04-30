package ru.itis.musicapp.data.api.mapper

import ru.itis.musicapp.data.api.response.chart.ChartTracksResponse
import ru.itis.musicapp.domain.models.Track
import javax.inject.Inject

class ChartTracksMapper @Inject constructor() {

    fun map(response: ChartTracksResponse): List<Track> {
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
