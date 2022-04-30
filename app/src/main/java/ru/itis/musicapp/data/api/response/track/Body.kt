package ru.itis.musicapp.data.api.response.track

import com.google.gson.annotations.SerializedName
import ru.itis.musicapp.data.api.response.common.TrackWrapper

data class Body(
    @SerializedName("track")
    val trackWr: TrackWrapper
)
