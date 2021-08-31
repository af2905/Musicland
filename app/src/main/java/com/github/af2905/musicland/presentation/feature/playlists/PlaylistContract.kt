package com.github.af2905.musicland.presentation.feature.playlists

import com.github.af2905.musicland.presentation.base.BasePresenter
import com.github.af2905.musicland.presentation.base.BaseView
import com.github.af2905.musicland.presentation.base.UiState
import com.github.af2905.musicland.presentation.widget.item.PlaylistItem
import com.github.af2905.musicland.presentation.widget.model.Model

interface PlaylistContract {
    interface Presenter : BasePresenter {
        fun onViewCreated()
        fun onRefreshData()
        fun onOpenDetailClicked(item: PlaylistItem)
    }

    interface View : BaseView<Presenter> {
        fun displayUiState(uiState: UiState, list: List<Model> = emptyList())
        fun forwardToDetail(item: PlaylistItem)
    }
}