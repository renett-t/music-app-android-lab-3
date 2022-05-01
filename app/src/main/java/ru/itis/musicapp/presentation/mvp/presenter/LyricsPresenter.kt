package ru.itis.musicapp.presentation.mvp.presenter

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import retrofit2.HttpException
import ru.itis.musicapp.domain.usecase.GetLyricsUseCase
import ru.itis.musicapp.domain.usecase.GetTrackUseCase
import ru.itis.musicapp.presentation.mvp.view.LyricsMvpView
import javax.inject.Inject

@InjectViewState
class LyricsPresenter @Inject constructor(
    private val getTrackUseCase: GetTrackUseCase,
    private val getLyricsUseCase: GetLyricsUseCase
) : MvpPresenter<LyricsMvpView>() {

    private val disposables = CompositeDisposable()

    fun getTrack(id: Int, commonId: Int) {
        disposables += getTrackUseCase(id, commonId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { track ->
                    viewState.showTrack(track)
                },
                onError = { error ->
                    if (error is HttpException) {
                        viewState.showError("Unable to get info due http error. Code = ${error.code()}")
                    } else {
                        viewState.showError("There was some error getting track for id = '$id', sorry :(")
                    }
                })
    }

    fun getLyrics(id: Int, commonId: Int) {
        disposables += getLyricsUseCase(id, commonId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { lyrics ->
                    viewState.showLyrics(lyrics)
                },
                onError = { error ->
                    if (error is HttpException) {
                        viewState.showError("Unable to get info due http error. Code = ${error.code()}")
                    } else {
                        viewState.showError("There was some error getting lyrics for track id = '$id', sorry :(")
                    }
                })
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }
}
