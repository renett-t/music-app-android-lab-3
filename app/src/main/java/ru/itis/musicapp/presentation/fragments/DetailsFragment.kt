package ru.itis.musicapp.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.itis.musicapp.R
import ru.itis.musicapp.databinding.FragmentDetailsBinding
import ru.itis.musicapp.domain.models.Lyrics
import ru.itis.musicapp.domain.models.Track
import ru.itis.musicapp.presentation.MainActivity
import ru.itis.musicapp.presentation.extension.*
import ru.itis.musicapp.presentation.mvp.presenter.LyricsPresenter
import ru.itis.musicapp.presentation.mvp.view.LyricsMvpView
import javax.inject.Inject

const val TRACK_ID = "track_id_key"
const val COMMON_ID = "track_id_key"

class DetailsFragment : MvpAppCompatFragment(R.layout.fragment_details), LyricsMvpView {
    private lateinit var binding: FragmentDetailsBinding

    @Inject
    @InjectPresenter
    lateinit var presenter: LyricsPresenter

    @ProvidePresenter
    fun providePresenter(): LyricsPresenter = presenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailsBinding.bind(view)

        showBackButton()

        val trackId = arguments?.getInt(TRACK_ID)
        val commonId = arguments?.getInt(COMMON_ID)
        if (trackId == null || commonId == null)
            showMessage("Something's wrong! Nothing to show")
        else
            getInfo(trackId, commonId)
    }

    private fun showBackButton() {
        setHasOptionsMenu(true)
        (activity as MainActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun getInfo(trackId: Int, commonId: Int) {
        presenter.getTrack(trackId, commonId)
        presenter.getLyrics(trackId, commonId)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> navigateToPreviousFragment()
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun navigateToPreviousFragment(): Boolean {
        findNavigationController(R.id.fragment_container).popBackStack()
        return true
    }

    private fun showMessage(message: String) {
        Snackbar.make(
            requireActivity().findViewById(R.id.fragment_container),
            message,
            Snackbar.LENGTH_LONG
        ).show()
    }

    override fun showTrack(track: Track) {
        with(binding) {
            tvTrack.text = track.title
            tvArtist.text = track.artist
            if (track.isExplicit)
                ivExplicit.visibility = View.VISIBLE
        }
    }

    override fun showLyrics(lyrics: Lyrics) {
        with(binding) {
            tvLyrics.text = lyrics.body
        }
    }

    override fun showError() {
        showMessage(getString(R.string.error_message))
    }

    override fun showError(message: String) {
        showMessage(message)
    }
}
