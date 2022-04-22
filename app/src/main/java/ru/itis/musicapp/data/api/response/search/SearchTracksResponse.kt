package ru.itis.musicapp.data.api.response.search

import com.google.gson.annotations.SerializedName
import ru.itis.musicapp.data.api.response.common.Message

data class SearchTracksResponse(
    @SerializedName("message")
    val message: Message
)
