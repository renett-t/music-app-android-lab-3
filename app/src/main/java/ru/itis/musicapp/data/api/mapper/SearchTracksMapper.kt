package ru.itis.musicapp.data.api.mapper

import ru.itis.musicapp.data.api.response.search.SearchTracksResponse
import ru.itis.musicapp.domain.models.Track
import javax.inject.Inject

class SearchTracksMapper @Inject constructor(){

    fun map(response: SearchTracksResponse) : List<Track> {
        val list = ArrayList<Track>()

        return list
    }
}
