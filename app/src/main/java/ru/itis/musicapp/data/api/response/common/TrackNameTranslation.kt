package ru.itis.musicapp.data.api.response.common

import com.google.gson.annotations.SerializedName

data class TrackNameTranslation(
    @SerializedName("language")
    val language: String,
    @SerializedName("translation")
    val translation: String
)
