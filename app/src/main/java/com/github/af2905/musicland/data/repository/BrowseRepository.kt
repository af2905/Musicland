package com.github.af2905.musicland.data.repository

import com.github.af2905.musicland.data.dto.CategoriesResponseDto
import com.github.af2905.musicland.data.dto.PlaylistsResponseDto
import com.github.af2905.musicland.data.network.api.BrowseApi
import com.github.af2905.musicland.domain.IBrowseRepository

class BrowseRepository(private val browseApi: BrowseApi) : IBrowseRepository {

    override suspend fun getCategories(
        country: String?,
        locale: String?,
        limit: Int?,
        offset: Int?
    ): CategoriesResponseDto {
        return browseApi.getBrowseCategories(country, locale, limit, offset)
    }

    override suspend fun getBrowseCategoriesPlaylists(
        categoryId: String,
        country: String?,
        limit: Int?,
        offset: Int?
    ): PlaylistsResponseDto {
        return browseApi.getBrowseCategoriesPlaylists(categoryId, country, limit, offset)
    }
}