package ru.itis.musicapp.data.api.response.lyrics

import com.google.gson.annotations.SerializedName

data class TrackLyricsResponse(
    @SerializedName("message")
    val message: Message
)
