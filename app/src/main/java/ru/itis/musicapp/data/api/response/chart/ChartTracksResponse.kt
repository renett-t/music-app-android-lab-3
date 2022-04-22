package ru.itis.musicapp.data.api.response.chart

import com.google.gson.annotations.SerializedName
import ru.itis.musicapp.data.api.response.common.Message

data class ChartTracksResponse(
    @SerializedName("message")
    val message: Message
)
