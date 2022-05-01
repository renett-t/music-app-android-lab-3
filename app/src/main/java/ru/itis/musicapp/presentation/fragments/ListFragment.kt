package ru.itis.musicapp.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.navigation.NavOptions
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.itis.musicapp.R
import ru.itis.musicapp.databinding.FragmentListBinding
import ru.itis.musicapp.di.modules.adapter.RecyclerViewAdapterFactory
import ru.itis.musicapp.domain.models.Track
import ru.itis.musicapp.presentation.MainActivity
import ru.itis.musicapp.presentation.extension.*
import ru.itis.musicapp.presentation.mvp.presenter.ListPresenter
import ru.itis.musicapp.presentation.mvp.view.ListMvpView
import ru.itis.musicapp.presentation.rv.TracksAdapter
import javax.inject.Inject

class ListFragment : MvpAppCompatFragment(R.layout.fragment_list), ListMvpView {
    private val defaultAmount = 15
    private val defaultCountry = "RU"
    private lateinit var binding: FragmentListBinding

    @Inject
    lateinit var adapterFactory: RecyclerViewAdapterFactory
    lateinit var tracksAdapter: TracksAdapter

    @Inject
    @InjectPresenter
    lateinit var presenter: ListPresenter

    @ProvidePresenter
    fun providePresenter(): ListPresenter = presenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)

        hideBackButton()
        initializeRecyclerView()
        initializeSearchBar()
//        presenter.getTrackListByCountry(defaultCountry, defaultAmount)
    }

    private fun hideBackButton() {
        (activity as MainActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
        }
    }

    private fun initializeRecyclerView() {
        tracksAdapter = adapterFactory.create { id1, id2 ->
            navigateToLyricsFragment(id1, id2)
        }
        binding.rvTracks.apply {
            adapter = tracksAdapter
            addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
        }
    }

    private fun initializeSearchBar() {
        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(text: String): Boolean {
                checkInputAndSearch(text)
                return false
            }

            override fun onQueryTextChange(text: String?): Boolean = false
        })
    }

    private fun checkInputAndSearch(text: String) {
        presenter.getTrackListBySearchQuery(text, defaultAmount)
    }

    private fun navigateToLyricsFragment(id: Int, comId: Int) {
        val bundle = Bundle().apply {
            putInt(TRACK_ID, id)
            putInt(COMMON_ID, comId)
        }

        val options = NavOptions.Builder()
            .setLaunchSingleTop(true)
            .setEnterAnim(R.anim.enter_from_right)
            .setExitAnim(R.anim.fade_out)
            .setPopEnterAnim(R.anim.fade_in)
            .setPopExitAnim(R.anim.exit_to_right)
            .build()

        findNavigationController(R.id.fragment_container).navigate(
            R.id.action_listFragment_to_detailsFragment,
            bundle,
            options
        )
    }

    private fun showMessage(message: String) {
        Snackbar.make(
            requireActivity().findViewById(R.id.fragment_container),
            message,
            Snackbar.LENGTH_SHORT
        ).show()
    }

    override fun showLoading() {
        with(binding) {
            progressBar.isVisible = true
            searchBar.isEnabled = false
        }
    }

    override fun hideLoading() {
        with(binding) {
            progressBar.isVisible = false
            searchBar.isEnabled = true
        }
    }

    override fun showTracksList(list: MutableList<Track>) {
        tracksAdapter.submitList(list)
    }

    override fun showError() {
        showMessage(getString(R.string.error_message))
    }

    override fun showError(message: String) {
        showMessage(message)
    }

}
