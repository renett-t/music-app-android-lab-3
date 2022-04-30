package ru.itis.musicapp.presentation.mvp.view

import moxy.viewstate.strategy.alias.AddToEndSingle
import ru.itis.musicapp.domain.models.Lyrics
import ru.itis.musicapp.domain.models.Track

@AddToEndSingle
interface LyricsMvpView : CommonMvpView {
    fun showTrack(track: Track)
    fun showLyrics(lyrics: Lyrics)
}
