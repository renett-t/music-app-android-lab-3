package ru.itis.musicapp.data.api.response.lyrics

import com.google.gson.annotations.SerializedName

data class Body(
    @SerializedName("lyrics")
    val lyrics: Lyrics
)
