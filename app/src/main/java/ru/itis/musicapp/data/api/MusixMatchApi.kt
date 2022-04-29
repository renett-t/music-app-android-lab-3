package ru.itis.musicapp.data.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.itis.musicapp.data.api.response.chart.ChartTracksResponse
import ru.itis.musicapp.data.api.response.lyrics.TrackLyricsResponse
import ru.itis.musicapp.data.api.response.search.SearchTracksResponse

interface MusixMatchApi {
    @GET("chart.tracks.get?chart_name=top&f_has_lyrics=1")
    fun getChartTracks(@Query("country") country: String, @Query("page") page: Int, @Query("page") pageSize: Int): Single<ChartTracksResponse>

    @GET("track.lyrics.get")
    fun getTrackLyrics(@Query("track_id") trackId: Int, @Query("commontrack_id") commontrackId: Int): Single<TrackLyricsResponse>

    @GET("track.search?s_artist_rating=desc")
    fun searchTracksByTrackTitle(@Query("q_track") trackQuery: String, @Query("page") page: Int, @Query("page") pageSize: Int): Single<SearchTracksResponse>

    @GET("track.search?s_track_rating=desc")
    fun searchTracksByArtist(@Query("q_artist") artistQuery: String, @Query("page") page: Int, @Query("page") pageSize: Int): Single<SearchTracksResponse>

    @GET("track.search?s_track_rating=desc")
    fun searchTracksByLyrics(@Query("q_lyrics") lyricsQuery: String, @Query("page") page: Int, @Query("page") pageSize: Int): Single<SearchTracksResponse>

    @GET("track.search?s_track_rating=desc")
    fun searchTracksByTrackTitleOrArtist(@Query("q_track_artist") query: String, @Query("page") page: Int, @Query("page") pageSize: Int): Single<SearchTracksResponse>
}
