package ru.itis.musicapp.domain.usecase

import io.reactivex.rxjava3.core.Single
import ru.itis.musicapp.domain.models.Track
import ru.itis.musicapp.domain.repository.TracksRepository
import javax.inject.Inject

class GetTracksBySearchQuery @Inject constructor(
    private val tracksRepository: TracksRepository
) {
    operator fun invoke(
        query: String,
        amount: Int
    ): Single<List<Track>> =
        tracksRepository.getTracksBySearchQuery(query, amount)
}
