package ru.itis.musicapp.presentation.mvp.presenter

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import retrofit2.HttpException
import ru.itis.musicapp.domain.usecase.GetChartTracksUseCase
import ru.itis.musicapp.domain.usecase.GetTracksBySearchQuery
import ru.itis.musicapp.presentation.mvp.view.ListMvpView
import javax.inject.Inject

@InjectViewState
class ListPresenter @Inject constructor(
    private val getChartTracksUseCase: GetChartTracksUseCase,
    private val getTracksBySearchQuery: GetTracksBySearchQuery
) : MvpPresenter<ListMvpView>() {

    private val disposables = CompositeDisposable()

    fun getTrackListByCountry(country: String, amount: Int) {
        disposables += getChartTracksUseCase(country, amount)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                viewState.showLoading()
            }
            .doAfterTerminate {
                viewState.hideLoading()
            }
            .subscribeBy(
                onNext = { list ->
                    viewState.showTracksList(list)
                },
                onError = { error ->
                    if (error is HttpException) {
                        viewState.showError("Unable to get info due http error. Code = ${error.code()}")
                    } else {
                        viewState.showError("There was some error getting chart tracks for country = '$country', sorry :(")
                    }
                })
    }

    fun getTrackListBySearchQuery(query: String, amount: Int) {
        disposables += getTracksBySearchQuery(query, amount)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                viewState.showLoading()
            }
            .doAfterTerminate {
                viewState.hideLoading()
            }
            .subscribeBy(
                onNext = { list ->
                    viewState.showTracksList(list)
                },
                onError = { error ->
                    if (error is HttpException) {
                        viewState.showError("Unable to get info due http error. Code = ${error.code()}")
                    } else {
                        viewState.showError("There was some error getting tracks for query = '$query', sorry :(")
                    }
                })
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }
}
