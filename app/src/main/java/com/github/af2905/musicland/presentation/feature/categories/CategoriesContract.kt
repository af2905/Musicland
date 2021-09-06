package com.github.af2905.musicland.presentation.feature.categories

import com.github.af2905.musicland.presentation.base.BasePresenter
import com.github.af2905.musicland.presentation.base.BaseView
import com.github.af2905.musicland.presentation.widget.item.CategoryItem
import com.github.af2905.musicland.presentation.widget.model.Model

interface CategoriesContract {
    interface Presenter : BasePresenter {
        fun onViewCreated()
        fun onRefreshData()
        fun onOpenDetailClicked(item: CategoryItem)
    }

    interface View : BaseView<Presenter> {
        fun displayLoading()
        fun displayItems(list: List<Model>)
        fun displayError()
        fun forwardToDetail(item: CategoryItem)
    }
}