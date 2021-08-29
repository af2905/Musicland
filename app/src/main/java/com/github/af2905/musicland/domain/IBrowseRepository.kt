package com.github.af2905.musicland.domain

import com.github.af2905.musicland.data.dto.CategoriesResponseDto
import com.github.af2905.musicland.data.dto.PlaylistsResponseDto

interface IBrowseRepository {
    suspend fun getCategories(
        country: String? = null, locale: String? = null, limit: Int? = null, offset: Int? = null
    ): CategoriesResponseDto

    suspend fun getBrowseCategoriesPlaylists(
        categoryId: String, country: String? = null, limit: Int? = null, offset: Int? = null
    ): PlaylistsResponseDto
}