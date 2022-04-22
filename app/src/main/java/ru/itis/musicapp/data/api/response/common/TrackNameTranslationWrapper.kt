package ru.itis.musicapp.data.api.response.common

import com.google.gson.annotations.SerializedName

data class TrackNameTranslationWrapper(
    @SerializedName("track_name_translation")
    val trackNameTranslation: TrackNameTranslation
)
