package com.github.af2905.musicland.presentation.feature.categories

import com.github.af2905.musicland.domain.interactor.BrowseInteractor
import com.github.af2905.musicland.presentation.widget.item.CategoryItem
import com.github.af2905.musicland.presentation.widget.item.GridListItem
import com.github.af2905.musicland.presentation.widget.model.Model
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*

class CategoriesPresenter(
    view: CategoriesContract.View,
    private val coroutineScope: CoroutineScope,
    private val browseInteractor: BrowseInteractor
) : CategoriesContract.Presenter {

    private var view: CategoriesContract.View? = view

    private val items = mutableListOf<Model>()

    override fun onViewCreated() {
        loadCategories()
    }

    override fun onRefreshData() {
        Timber.tag("REFRESH_DATA").i("I'm here")

        loadCategories()
    }

    override fun onOpenDetailClicked(item: CategoryItem) {
        view?.forwardToDetail(item)
    }

    private fun loadCategories() {
        view?.displayLoading()
        coroutineScope.launch {
            val categories = browseInteractor.getCategories()
            if (!categories.isNullOrEmpty()) {

                val random = Random()
                val randomCategories =
                    if (random.nextInt() >= categories.size) categories.take(categories.size)
                    else categories.take(3)
                items.clear()

                val gridListItemId = random.nextInt().toString()

                items.add(GridListItem(randomCategories, id = gridListItemId))

                Timber.tag("REFRESH_DATA").i("${items.size}")

                view?.displayItems(items)
            } else {
                view?.displayError()
            }
        }
    }
}