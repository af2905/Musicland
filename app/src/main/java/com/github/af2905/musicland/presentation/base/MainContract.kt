package com.github.af2905.musicland.presentation.base

interface MainContract {
    interface Presenter : BasePresenter {
        fun onViewCreated()
        fun loadData()
    }

    interface View : BaseView<Presenter> {
        fun displayUiState(uiState: UiState)
    }
}