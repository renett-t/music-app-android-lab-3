package ru.itis.musicapp.data.api.response.common

import com.google.gson.annotations.SerializedName

data class Track(
    @SerializedName("track_id")
    val trackId: Int,
    @SerializedName("track_name")
    val trackName: String,
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
    @SerializedName("restricted")
    val restricted: Int,
    @SerializedName("track_rating")
    val trackRating: Int,
    @SerializedName("updated_time")
    val updatedTime: String
)
