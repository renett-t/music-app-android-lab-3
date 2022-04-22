package ru.itis.musicapp.data.api.response.lyrics

import com.google.gson.annotations.SerializedName

data class Lyrics (
    @SerializedName("lyrics_id")
    val id: Int,
    @SerializedName("lyrics_body")
    val body: String,
    @SerializedName("lyrics_copyright")
    val copyright: String,
    @SerializedName("pixel_tracking_url")
    val pixelTrackingUrl: String,
    @SerializedName("script_tracking_url")
    val scriptTrackingUrl: String,
    @SerializedName("updated_time")
    val updatedTime: String,
    @SerializedName("explicit")
    val explicit: Int,
)
