package ru.itis.musicapp.data.api.response.lyrics

import com.google.gson.annotations.SerializedName
import ru.itis.musicapp.data.api.response.common.Message

data class TrackLyricsResponse(
    @SerializedName("message")
    val message: Message
)
