package ru.itis.musicapp.data.repository

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import ru.itis.musicapp.data.api.MusixMatchApi
import ru.itis.musicapp.data.api.mapper.*
import ru.itis.musicapp.data.api.response.chart.ChartTracksResponse
import ru.itis.musicapp.data.api.response.search.SearchTracksResponse
import ru.itis.musicapp.domain.exception.TracksNotFoundException
import ru.itis.musicapp.domain.models.Track
import ru.itis.musicapp.domain.repository.TracksRepository
import javax.inject.Inject
import kotlin.reflect.KFunction3

private const val MAX_PAGE_SIZE = 100

class TracksRepositoryImpl @Inject constructor(
    private val api: MusixMatchApi,
    private val chartTracksMapper: ChartTracksMapper,
    private val searchTracksMapper: SearchTracksMapper,
    private val trackMapper: TrackMapper
): TracksRepository {

    override fun getTrackByIds(trackId: Int, commonId: Int): Single<Track> {
        return api.getTrack(trackId, commonId).map {
            trackMapper.map(it)
        }
    }

    override fun getChartTracksForCountry(country: String, amount: Int): Observable<MutableList<Track>> {
        return getChartTracks(country, amount, api::getChartTracks)
            ?.map {
                chartTracksMapper.map(it)
            } ?: throw TracksNotFoundException("Unable to get $amount tracks for country = $country")
    }

    override fun getTracksBySearchQuery(query: String, amount: Int): Observable<MutableList<Track>> {
        return getTracksBySomeQuery(query, amount, api::searchTracksByTrackTitleOrArtist)
            ?.map {
                searchTracksMapper.map(it)
            } ?: throw TracksNotFoundException("Unable to get $amount tracks for query = $query")
    }

    override fun getTracksByTrackTitle(query: String, amount: Int): Observable<MutableList<Track>> {
        return getTracksBySomeQuery(query, amount, api::searchTracksByTrackTitle)
            ?.map {
                searchTracksMapper.map(it)
            } ?: throw TracksNotFoundException("Unable to get $amount tracks for query = $query")
    }

    override fun getTracksByArtistName(query: String, amount: Int): Observable<MutableList<Track>> {
        return getTracksBySomeQuery(query, amount, api::searchTracksByArtist)
            ?.map {
                searchTracksMapper.map(it)
            } ?: throw TracksNotFoundException("Unable to get $amount tracks for query = $query")
    }

    override fun getTracksByLyricsPiece(query: String, amount: Int): Observable<MutableList<Track>> {
        return getTracksBySomeQuery(query, amount, api::searchTracksByLyrics)
            ?.map {
                searchTracksMapper.map(it)
            } ?: throw TracksNotFoundException("Unable to get $amount tracks for query = $query")
    }

    private fun getTracksBySomeQuery(query: String, amount: Int, requestFun: KFunction3<String, Int, Int, Single<SearchTracksResponse>>): Observable<SearchTracksResponse>? {
        return if (amount > MAX_PAGE_SIZE) {
            var page = 1
            var amountLeft = amount - MAX_PAGE_SIZE
            var response = requestFun(query, page, MAX_PAGE_SIZE).toObservable()

            while (amount > 0) {
                val newResponse = requestFun(query, page++, amountLeft)
                response = response.mergeWith(newResponse)
                amountLeft = amount - MAX_PAGE_SIZE
            }

            response
        } else
            requestFun(query, 0, amount).toObservable()
    }

    private fun getChartTracks(query: String, amount: Int, requestFun: KFunction3<String, Int, Int, Single<ChartTracksResponse>>): Observable<ChartTracksResponse>? {
        return if (amount > MAX_PAGE_SIZE) {
            var page = 1
            var amountLeft = amount - MAX_PAGE_SIZE
            var response = requestFun(query, page, MAX_PAGE_SIZE).toObservable()

            while (amount > 0) {
                val newResponse = requestFun(query, page++, amountLeft)
                response = response.mergeWith(newResponse)
                amountLeft = amount - MAX_PAGE_SIZE
            }

            response
        } else
            requestFun(query, 0, amount).toObservable()
    }
}
