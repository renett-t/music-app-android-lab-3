package ru.itis.musicapp.domain.repository

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import ru.itis.musicapp.domain.models.Track

interface TracksRepository {
    fun getTrackByIds(trackId: Int, commonId: Int): Single<Track>
    fun getChartTracksForCountry(country: String, amount: Int) : Observable<List<Track>>
    fun getTracksBySearchQuery(query: String, amount: Int): Observable<List<Track>>
    fun getTracksByTrackTitle(query: String, amount: Int): Observable<List<Track>>
    fun getTracksByArtistName(query: String, amount: Int): Observable<List<Track>>
    fun getTracksByLyricsPiece(query: String, amount: Int): Observable<List<Track>>
}
