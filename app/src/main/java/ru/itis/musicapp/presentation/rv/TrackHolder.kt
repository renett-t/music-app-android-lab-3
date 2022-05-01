package ru.itis.musicapp.presentation.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.itis.musicapp.databinding.TrackItemBinding
import ru.itis.musicapp.domain.models.Track

class TrackHolder(
    private val binding: TrackItemBinding,
    private val onItemChosenAction: (Int, Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    private var track: Track? = null

    init {
        itemView.setOnClickListener {
            track?.let {
                onItemChosenAction(it.id, it.commonId)
            }
        }
    }

    fun bind(track: Track): Unit {
        this.track = track
        with(binding) {
            tvArtist.text = track.artist
            tvTrack.text = track.title
            if (track.isExplicit)
                ivExplicit.visibility = View.VISIBLE
        }
    }

    companion object {
        fun create(parent: ViewGroup, onItemChosenAction: (Int, Int) -> Unit): TrackHolder {
            return TrackHolder(
                TrackItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ),
                onItemChosenAction
            )
        }
    }
}
