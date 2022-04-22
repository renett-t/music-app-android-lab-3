package ru.itis.musicapp.data.api.response.search

import com.google.gson.annotations.SerializedName

data class Body(
    @SerializedName("track_list")
    val track_list: List<Track>
)
