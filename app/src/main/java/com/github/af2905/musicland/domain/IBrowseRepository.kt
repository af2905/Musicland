package com.github.af2905.musicland.domain

import com.github.af2905.musicland.data.CategoriesResponseDto

interface IBrowseRepository {
    suspend fun getCategories(
        country: String? = null, locale: String? = null, limit: Int? = null, offset: Int? = null
    ): CategoriesResponseDto
}