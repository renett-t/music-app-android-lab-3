package ru.itis.musicapp.data.api.response.common

import com.google.gson.annotations.SerializedName
import ru.itis.musicapp.data.api.response.chart.Body

data class Message(
    @SerializedName("body")
    val body: Body,
    @SerializedName("header")
    val header: Header
)
