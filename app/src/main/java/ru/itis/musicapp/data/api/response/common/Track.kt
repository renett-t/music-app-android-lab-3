package ru.itis.musicapp.data.api.response.common

import com.google.gson.annotations.SerializedName

data class Track(
    @SerializedName("album_id")
    val albumId: Int,
    @SerializedName("album_name")
    val albumName: String,
    @SerializedName("artist_id")
    val artistId: Int,
    @SerializedName("artist_name")
    val artistName: String,
    @SerializedName("commontrack_id")
    val commontrackId: Int,
    @SerializedName("explicit")
    val explicit: Int,
    @SerializedName("has_lyrics")
    val hasLyrics: Int,
    @SerializedName("has_richsync")
    val hasRichsync: Int,
    @SerializedName("has_subtitles")
    val hasSubtitles: Int,
    @SerializedName("instrumental")
    val instrumental: Int,
    @SerializedName("num_favourite")
    val numFavourite: Int,
    @SerializedName("primary_genres")
    val primaryGenres: PrimaryGenres,
    @SerializedName("restricted")
    val restricted: Int,
    @SerializedName("track_edit_url")
    val trackEdiUrl: String,
    @SerializedName("track_id")
    val trackId: Int,
    @SerializedName("track_name")
    val trackName: String,
    @SerializedName("track_name_translation_list")
    val trackNameTranslationList: List<TrackNameTranslationWrapper>,
    @SerializedName("track_rating")
    val trackRating: Int,
    @SerializedName("track_share_url")
    val trackShareUrl: String,
    @SerializedName("updated_time")
    val updatedTime: String
)
