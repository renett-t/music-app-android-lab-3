package ru.itis.musicapp.domain.models

data class Lyrics(
    private val id: Int,
    private val body: String,
    private val isExplicit: Boolean,
)
