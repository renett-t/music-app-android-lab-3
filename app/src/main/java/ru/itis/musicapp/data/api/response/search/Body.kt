package ru.itis.musicapp.data.api.response.search

import com.google.gson.annotations.SerializedName
import ru.itis.musicapp.data.api.response.common.TrackWrapper

data class Body(
    @SerializedName("track_list")
    val tracks: List<TrackWrapper>
)
