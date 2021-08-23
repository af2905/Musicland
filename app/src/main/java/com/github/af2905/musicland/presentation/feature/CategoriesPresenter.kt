package com.github.af2905.musicland.presentation.feature

import com.github.af2905.musicland.di.DependencyInjector
import com.github.af2905.musicland.domain.interactor.BrowseInteractor
import com.github.af2905.musicland.presentation.base.UiState
import com.github.af2905.musicland.presentation.widget.item.CategoryItem
import com.github.af2905.musicland.presentation.widget.item.LoadingItem
import com.github.af2905.musicland.presentation.widget.model.Model
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriesPresenter(
    view: CategoriesContract.View,
    dependencyInjector: DependencyInjector
) : CategoriesContract.Presenter {

    private val browseInteractor = BrowseInteractor(dependencyInjector.browseRepository())

    private var view: CategoriesContract.View? = view

    private val items = mutableListOf<Model>()
    private fun starter() = mutableListOf(LoadingItem())

    override fun onViewCreated() {
        loadCategories()
    }

    override fun loadData() {
        loadCategories()
    }

    override fun onOpenDetailClicked(item: CategoryItem) {
        view?.forwardToDetail(item)
    }

    override fun onDestroy() {
        this.view = null
    }

    private fun loadCategories() {
        view?.displayUiState(UiState.LOADING, starter())
        CoroutineScope(Dispatchers.Main).launch {
            val categories = browseInteractor.getCategories()
            if (!categories.isNullOrEmpty()) {
                items.addAll(categories)
                view?.displayUiState(UiState.SUCCESS, items)
            } else {
                view?.displayUiState(UiState.FAIL)
            }
        }
    }
}