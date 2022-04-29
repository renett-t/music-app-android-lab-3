package ru.itis.musicapp.data.api.response.common

import com.google.gson.annotations.SerializedName

data class TrackWrapper(
    @SerializedName("track")
    val track: Track
)
