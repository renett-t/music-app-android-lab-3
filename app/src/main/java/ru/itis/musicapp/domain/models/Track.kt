package ru.itis.musicapp.domain.models

data class Track(
    val id: Int,
    val commonId: Int,
    val title: String,
    val artist: String,
    val isExplicit: Boolean,
    val hasLyrics: Boolean,
)
