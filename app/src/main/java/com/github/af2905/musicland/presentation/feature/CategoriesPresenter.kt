package com.github.af2905.musicland.presentation.feature

import com.github.af2905.musicland.di.DependencyInjector
import com.github.af2905.musicland.domain.interactor.BrowseInteractor
import com.github.af2905.musicland.presentation.base.MainContract
import com.github.af2905.musicland.presentation.base.UiState
import kotlinx.coroutines.*

class CategoriesPresenter(
    view: MainContract.View,
    dependencyInjector: DependencyInjector
) : MainContract.Presenter {

    private val browseInteractor = BrowseInteractor(dependencyInjector.browseRepository())

    private var view: MainContract.View? = view

    override fun onViewCreated() {
        loadCategories()
    }

    override fun loadData() {
        loadCategories()
    }

    override fun onDestroy() {
        this.view = null
    }

    private fun loadCategories() {
        view?.displayUiState(UiState.LOADING)
        CoroutineScope(Dispatchers.Main).launch {
            val categories = browseInteractor.getCategories()
            if (!categories.categoriesDto.items.isNullOrEmpty()) {
                view?.displayUiState(UiState.SUCCESS)
            } else {
                view?.displayUiState(UiState.FAIL)
            }
        }
    }
}