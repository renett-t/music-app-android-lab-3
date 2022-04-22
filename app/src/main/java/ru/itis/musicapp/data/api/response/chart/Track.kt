package ru.itis.musicapp.data.api.response.chart

import com.google.gson.annotations.SerializedName

data class Track(
    @SerializedName("track")
    val track: TrackX
)
