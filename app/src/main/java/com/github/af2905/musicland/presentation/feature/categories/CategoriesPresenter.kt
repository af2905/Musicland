package com.github.af2905.musicland.presentation.feature.categories

import com.github.af2905.musicland.domain.interactor.BrowseInteractor
import com.github.af2905.musicland.presentation.base.UiState
import com.github.af2905.musicland.presentation.widget.item.CategoryItem
import com.github.af2905.musicland.presentation.widget.item.GridListItem
import com.github.af2905.musicland.presentation.widget.item.LoadingItem
import com.github.af2905.musicland.presentation.widget.model.Model
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class CategoriesPresenter(
    view: CategoriesContract.View,
    private val coroutineScope: CoroutineScope,
    private val browseInteractor: BrowseInteractor
) : CategoriesContract.Presenter {

    private var view: CategoriesContract.View? = view

    private val items = mutableListOf<Model>()
    private fun starter() = mutableListOf(LoadingItem())

    override fun onViewCreated() {
        loadCategories()
    }

    override fun onRefreshData() {
        loadCategories()
    }

    override fun onOpenDetailClicked(item: CategoryItem) {
        view?.forwardToDetail(item)
    }

    private fun loadCategories() {
        view?.displayUiState(UiState.LOADING, starter())
        coroutineScope.launch {
            val categories = browseInteractor.getCategories()
            if (!categories.isNullOrEmpty()) {
                items.add(GridListItem(categories))
                view?.displayUiState(UiState.SUCCESS, items)
            } else {
                view?.displayUiState(UiState.FAIL)
            }
        }
    }
}