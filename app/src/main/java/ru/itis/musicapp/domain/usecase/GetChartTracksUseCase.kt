package ru.itis.musicapp.domain.usecase

import io.reactivex.rxjava3.core.Single
import ru.itis.musicapp.domain.models.Track
import ru.itis.musicapp.domain.repository.TracksRepository
import javax.inject.Inject

class GetChartTracksUseCase @Inject constructor(
    private val tracksRepository: TracksRepository
) {
    operator fun invoke(
        country: String,
        amount: Int
    ): Single<List<Track>> =
        tracksRepository.getChartTracksForCountry(country, amount)
}
