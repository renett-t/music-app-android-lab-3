package ru.itis.musicapp.data.api.response.chart

import com.google.gson.annotations.SerializedName

data class Body (
    @SerializedName("track_list")
    val tracks: List<Track>
)
