package com.github.af2905.musicland.domain.interactor

import com.github.af2905.musicland.data.mapper.CategoriesDtoToUiMapper
import com.github.af2905.musicland.data.mapper.PlaylistsDtoToUiMapper
import com.github.af2905.musicland.domain.IBrowseRepository
import com.github.af2905.musicland.presentation.widget.item.CategoryItem
import com.github.af2905.musicland.presentation.widget.item.PlaylistItem

class BrowseInteractor(
    private val browseRepository: IBrowseRepository,
    private val categoriesMapper: CategoriesDtoToUiMapper,
    private val playlistsMapper: PlaylistsDtoToUiMapper
) {

    suspend fun getCategories(
        country: String? = null, locale: String? = null, limit: Int? = null, offset: Int? = null
    ): List<CategoryItem> {
        return categoriesMapper.map(
            browseRepository.getCategories(country, locale, limit, offset).categoriesDto.items
                ?: emptyList()
        )
    }

    suspend fun getPlaylists(
        categoryId: String, country: String? = null, limit: Int? = null, offset: Int? = null
    ): List<PlaylistItem> {
        return playlistsMapper.map(
            browseRepository.getBrowseCategoriesPlaylists(
                categoryId, country, limit, offset
            ).playlistsDto.items
        )
    }

}