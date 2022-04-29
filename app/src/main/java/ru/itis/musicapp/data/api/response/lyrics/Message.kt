package ru.itis.musicapp.data.api.response.lyrics

import com.google.gson.annotations.SerializedName
import ru.itis.musicapp.data.api.response.common.Header

data class Message(
    @SerializedName("body")
    val body: Body,
    @SerializedName("header")
    val header: Header
)
