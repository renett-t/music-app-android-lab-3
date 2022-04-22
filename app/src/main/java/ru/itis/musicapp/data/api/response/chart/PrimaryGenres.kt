package ru.itis.musicapp.data.api.response.chart

import com.google.gson.annotations.SerializedName

data class PrimaryGenres(
    @SerializedName("music_genre_list")
    val genres: List<MusicGenre>
)
