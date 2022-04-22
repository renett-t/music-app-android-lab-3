package ru.itis.musicapp.data.api.response.chart

import com.google.gson.annotations.SerializedName

data class MusicGenre(
    @SerializedName("music_genre")
    val genre: MusicGenreX
)
