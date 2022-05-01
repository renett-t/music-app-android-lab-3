package ru.itis.musicapp.domain.models

data class Lyrics(
    val id: Int,
    val body: String,
    val isExplicit: Boolean,
)
