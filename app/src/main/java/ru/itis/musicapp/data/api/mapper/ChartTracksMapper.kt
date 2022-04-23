package ru.itis.musicapp.data.api.mapper

import ru.itis.musicapp.data.api.response.chart.ChartTracksResponse
import ru.itis.musicapp.domain.models.Track
import javax.inject.Inject

class ChartTracksMapper @Inject constructor() {

    fun map(response: ChartTracksResponse): List<Track> {
        val list = ArrayList<Track>()

        return list
    }
}
