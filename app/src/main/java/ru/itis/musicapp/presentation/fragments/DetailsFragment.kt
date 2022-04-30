package ru.itis.musicapp.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.itis.musicapp.R
import ru.itis.musicapp.databinding.FragmentDetailsBinding
import ru.itis.musicapp.presentation.MainActivity
import ru.itis.musicapp.presentation.extension.appComponent

const val TRACK_ID = "track_id_key"
const val COMMON_ID = "track_id_key"
class DetailsFragment: Fragment(R.layout.fragment_details) {
    private lateinit var binding: FragmentDetailsBinding

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
        initializeView(trackId, commonId)
    }

    private fun initializeView(trackId: Int?, commonId: Int?) {
        TODO("Not yet implemented")
    }

    private fun showBackButton() {
        setHasOptionsMenu(true)
        (activity as MainActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
        }
    }


}
