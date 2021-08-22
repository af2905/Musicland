package com.github.af2905.musicland.presentation.feature

import com.github.af2905.musicland.di.DependencyInjector
import com.github.af2905.musicland.domain.interactor.BrowseInteractor
import com.github.af2905.musicland.presentation.base.UiState
import com.github.af2905.musicland.presentation.widget.item.CategoryItem
import kotlinx.coroutines.*

class CategoriesPresenter(
    view: CategoriesContract.View,
    dependencyInjector: DependencyInjector
) : CategoriesContract.Presenter {

    private val browseInteractor = BrowseInteractor(dependencyInjector.browseRepository())

    private var view: CategoriesContract.View? = view

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
        view?.displayUiState(UiState.LOADING)
        CoroutineScope(Dispatchers.Main).launch {
            val categories = browseInteractor.getCategories()
            if (!categories.isNullOrEmpty()) {
                view?.displayUiState(UiState.SUCCESS, categories)
            } else {
                view?.displayUiState(UiState.FAIL)
            }
        }
    }
}