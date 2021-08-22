package com.github.af2905.musicland.presentation.feature

import com.github.af2905.musicland.presentation.base.BasePresenter
import com.github.af2905.musicland.presentation.base.BaseView
import com.github.af2905.musicland.presentation.base.UiState
import com.github.af2905.musicland.presentation.widget.item.CategoryItem

interface CategoriesContract {
    interface Presenter : BasePresenter {
        fun onViewCreated()
        fun loadData()
        fun onOpenDetailClicked(item: CategoryItem)
    }

    interface View : BaseView<Presenter> {
        fun displayUiState(uiState: UiState, list: List<CategoryItem> = emptyList())
        fun forwardToDetail(item: CategoryItem)
    }
}