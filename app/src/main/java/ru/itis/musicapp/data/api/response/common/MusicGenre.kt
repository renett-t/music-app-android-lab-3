package ru.itis.musicapp.data.api.response.common

import com.google.gson.annotations.SerializedName

data class MusicGenre(
    @SerializedName("music_genre_id")
    val id: Int,
    @SerializedName("music_genre_name")
    val name: String,
    @SerializedName("music_genre_name_extended")
    val nameExtended: String,
    @SerializedName("music_genre_parent_id")
    val parentId: Int,
    @SerializedName("music_genre_vanity")
    val vanity: String
)
