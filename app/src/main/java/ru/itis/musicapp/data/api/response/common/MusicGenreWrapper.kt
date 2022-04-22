package ru.itis.musicapp.data.api.response.common

import com.google.gson.annotations.SerializedName

data class MusicGenreWrapper(
    @SerializedName("music_genre")
    val genre: MusicGenre
)
