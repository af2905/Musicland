package com.github.af2905.musicland.data.repository

import com.github.af2905.musicland.data.CategoriesResponseDto
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
}