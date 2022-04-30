package ru.itis.musicapp.domain.usecase

import io.reactivex.rxjava3.core.Observable
import ru.itis.musicapp.domain.models.Track
import ru.itis.musicapp.domain.repository.TracksRepository
import javax.inject.Inject

class GetTracksByArtistName @Inject constructor(
    private val tracksRepository: TracksRepository
) {
    operator fun invoke(
        query: String,
        amount: Int
    ): Observable<MutableList<Track>> =
        tracksRepository.getTracksByArtistName(query, amount)
}
