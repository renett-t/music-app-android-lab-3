package ru.itis.musicapp.data.repository

import io.reactivex.rxjava3.core.Single
import ru.itis.musicapp.domain.models.Track
import ru.itis.musicapp.domain.repository.TracksRepository
import javax.inject.Inject

class TracksRepositoryImpl @Inject constructor(

): TracksRepository {
    override fun getChartTracksForCountry(country: String, amount: Int): Single<List<Track>> {
        TODO("Not yet implemented")
    }

    override fun getTracksBySearchQuery(query: String, amount: Int): Single<List<Track>> {
        TODO("Not yet implemented")
    }

    override fun getTracksByTrackTitle(query: String, amount: Int): Single<List<Track>> {
        TODO("Not yet implemented")
    }

    override fun getTracksByArtistName(query: String, amount: Int): Single<List<Track>> {
        TODO("Not yet implemented")
    }

    override fun getTracksByLyricsPiece(query: String, amount: Int): Single<List<Track>> {
        TODO("Not yet implemented")
    }
}
