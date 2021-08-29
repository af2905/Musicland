package com.github.af2905.musicland.presentation.feature.playlists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.github.af2905.musicland.R
import com.github.af2905.musicland.databinding.FragmentPlaylistsBinding
import com.github.af2905.musicland.di.DependencyInjector
import com.github.af2905.musicland.domain.interactor.BrowseInteractor
import com.github.af2905.musicland.helper.putArgs
import com.github.af2905.musicland.presentation.base.UiState
import com.github.af2905.musicland.presentation.widget.adapter.delegate.CompositeDelegateAdapter
import com.github.af2905.musicland.presentation.widget.decorator.GridListItemDecorator
import com.github.af2905.musicland.presentation.widget.item.*
import com.github.af2905.musicland.presentation.widget.model.Model

class PlaylistsFragment : Fragment(), PlaylistContract.View {

    private lateinit var presenter: PlaylistContract.Presenter

    private lateinit var binding: FragmentPlaylistsBinding
    private lateinit var adapter: CompositeDelegateAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlaylistsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoryId = requireArguments().getString(CATEGORY_ID_ARG)!!
        val browseInteractor = BrowseInteractor(DependencyInjector().browseRepository())
        setPresenter(PlaylistsPresenter(categoryId, this, lifecycleScope, browseInteractor))
        adapter = CompositeDelegateAdapter(
            LoadingDelegate(LoadingItem.VIEW_TYPE),
            GridListDelegate(
                viewType = GridListItem.VIEW_TYPE,
                adapter = {
                    CompositeDelegateAdapter(
                        PlaylistDelegate(PlaylistItem.VIEW_TYPE) { presenter.onOpenDetailClicked(it) }
                    )
                },
                decoration = {
                    GridListItemDecorator(
                        marginBottom = it.resources.getDimensionPixelSize(R.dimen.default_margin),
                        marginStart = it.resources.getDimensionPixelSize(R.dimen.default_margin),
                        marginEnd = it.resources.getDimensionPixelSize(R.dimen.default_margin),
                        spacing = it.resources.getDimensionPixelSize(R.dimen.default_margin_small)
                    )
                }
            )
        )
        recyclerView = binding.playlistsRecyclerView
        recyclerView.adapter = adapter
        presenter.onViewCreated()
    }

    companion object {
        fun newInstance(categoryId: String) = PlaylistsFragment().putArgs {
            putString(CATEGORY_ID_ARG, categoryId)
        }

        val TAG: String = PlaylistsFragment::class.java.simpleName
        const val CATEGORY_ID_ARG = "CATEGORY_ID_ARG"
    }

    override fun displayUiState(uiState: UiState, list: List<Model>) {
        when (uiState) {
            UiState.LOADING -> adapter.submitList(list)
            UiState.SUCCESS -> adapter.submitList(list)
            UiState.FAIL -> Toast.makeText(requireContext(), "fail", Toast.LENGTH_SHORT).show()
        }
    }

    override fun forwardToDetail(item: PlaylistItem) {
        Toast.makeText(requireContext(), item.name, Toast.LENGTH_SHORT).show()
    }

    override fun setPresenter(presenter: PlaylistContract.Presenter) {
        this.presenter = presenter
    }
}