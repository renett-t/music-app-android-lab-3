package ru.itis.musicapp.domain.usecase

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.itis.musicapp.domain.models.Lyrics
import ru.itis.musicapp.domain.repository.LyricsRepository
import javax.inject.Inject

class GetLyricsUseCase @Inject constructor(
    private val lyricsRepository: LyricsRepository
) {

    operator fun invoke(
        trackId: Int,
        commontrackId: Int
    ): Single<Lyrics> =
        lyricsRepository.getLyricsById(trackId, commontrackId)
            .subscribeOn(Schedulers.io())

}
