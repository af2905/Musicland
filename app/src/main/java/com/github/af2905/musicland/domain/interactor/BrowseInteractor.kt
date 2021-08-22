package com.github.af2905.musicland.domain.interactor

import com.github.af2905.musicland.domain.IBrowseRepository
import com.github.af2905.musicland.presentation.widget.item.CategoryItem

class BrowseInteractor(private val browseRepository: IBrowseRepository) {

    suspend fun getCategories(
        country: String? = null, locale: String? = null, limit: Int? = null, offset: Int? = null
    ): List<CategoryItem> {
        return CategoryItem.map(
            browseRepository.getCategories(country, locale, limit, offset).categoriesDto.items
        )
    }
}