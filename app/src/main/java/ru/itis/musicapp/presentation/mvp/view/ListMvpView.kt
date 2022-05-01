package ru.itis.musicapp.presentation.mvp.view

import moxy.viewstate.strategy.alias.AddToEndSingle
import ru.itis.musicapp.domain.models.Track

@AddToEndSingle
interface ListMvpView : CommonMvpView {
    fun showLoading()
    fun hideLoading()
    fun showTracksList(list: MutableList<Track>)
}
