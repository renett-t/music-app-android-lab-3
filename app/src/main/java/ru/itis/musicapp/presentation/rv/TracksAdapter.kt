package ru.itis.musicapp.presentation.rv

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import ru.itis.musicapp.domain.models.Track

class TracksAdapter @AssistedInject constructor(
    @Assisted("onItemChosenAction")
    private val onItemChosenAction: (Int, Int) -> Unit
) : ListAdapter<Track, TrackHolder>(DiffUtilItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackHolder =
        TrackHolder.create(parent, onItemChosenAction)

    override fun onBindViewHolder(holder: TrackHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DiffUtilItemCallback : DiffUtil.ItemCallback<Track>() {
    override fun areItemsTheSame(oldItem: Track, newItem: Track)
            = oldItem.id == newItem.id && oldItem.commonId == newItem.commonId

    override fun areContentsTheSame(oldItem: Track, newItem: Track)
            = oldItem == newItem
}
