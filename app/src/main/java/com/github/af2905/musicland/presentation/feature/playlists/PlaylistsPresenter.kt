package com.github.af2905.musicland.presentation.feature.playlists

import com.github.af2905.musicland.domain.interactor.BrowseInteractor
import com.github.af2905.musicland.presentation.base.UiState
import com.github.af2905.musicland.presentation.widget.item.GridListItem
import com.github.af2905.musicland.presentation.widget.item.LoadingItem
import com.github.af2905.musicland.presentation.widget.item.PlaylistItem
import com.github.af2905.musicland.presentation.widget.model.Model
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class PlaylistsPresenter(
    private val categoryId: String,
    view: PlaylistContract.View,
    private val coroutineScope: CoroutineScope,
    private val browseInteractor: BrowseInteractor
) : PlaylistContract.Presenter {

    private var view: PlaylistContract.View? = view

    private val items = mutableListOf<Model>()
    private fun starter() = mutableListOf(LoadingItem())

    override fun onViewCreated() {
        loadCategories()
    }

    override fun onRefreshData() {
        loadCategories()
    }

    override fun onOpenDetailClicked(item: PlaylistItem) {
        view?.forwardToDetail(item)
    }

    private fun loadCategories() {
        view?.displayUiState(UiState.LOADING, starter())
        coroutineScope.launch {
            val categories = browseInteractor.getPlaylists(categoryId)
            if (!categories.isNullOrEmpty()) {
                items.add(GridListItem(categories))
                view?.displayUiState(UiState.SUCCESS, items)
            } else {
                view?.displayUiState(UiState.FAIL)
            }
        }
    }
}