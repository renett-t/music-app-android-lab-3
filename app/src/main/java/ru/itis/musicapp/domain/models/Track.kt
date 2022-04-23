package ru.itis.musicapp.domain.models

data class Track(
    private val id: Int,
    private val commonId: Int,
    private val title: String,
    private val artist: String,
    private val isExplicit: Boolean,
    private val hasLyrics: Boolean,
    private val lyrics: Lyrics?
)
