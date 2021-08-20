package com.github.af2905.musicland.domain.interactor

import com.github.af2905.musicland.data.CategoriesResponseDto
import com.github.af2905.musicland.domain.IBrowseRepository

class BrowseInteractor(private val browseRepository: IBrowseRepository) {

    suspend fun getCategories(
        country: String? = null, locale: String? = null, limit: Int? = null, offset: Int? = null
    ): CategoriesResponseDto {
        return browseRepository.getCategories(country, locale, limit, offset)
    }
}