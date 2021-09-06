package com.github.af2905.musicland.di

import com.github.af2905.musicland.data.mapper.CategoriesDtoToUiMapper
import com.github.af2905.musicland.data.mapper.CategoryDtoToUiMapper
import com.github.af2905.musicland.data.mapper.PlaylistDtoToUiMapper
import com.github.af2905.musicland.data.mapper.PlaylistsDtoToUiMapper
import com.github.af2905.musicland.data.network.OkHttpClientHelper
import com.github.af2905.musicland.data.network.RetrofitClientHelper
import com.github.af2905.musicland.data.network.api.BrowseApiHelper
import com.github.af2905.musicland.data.network.interceptor.HttpHeaderInterceptor
import com.github.af2905.musicland.data.network.interceptor.HttpLoggerInterceptor
import com.github.af2905.musicland.data.network.interceptor.HttpLoggingInterceptorHelper
import com.github.af2905.musicland.data.repository.BrowseRepository
import com.github.af2905.musicland.domain.interactor.BrowseInteractor
import com.github.af2905.musicland.presentation.feature.categories.CategoriesContract
import com.github.af2905.musicland.presentation.feature.categories.CategoriesPresenter
import com.github.af2905.musicland.presentation.feature.playlists.PlaylistContract
import com.github.af2905.musicland.presentation.feature.playlists.PlaylistsPresenter
import kotlinx.coroutines.CoroutineScope

object DependencyInjector {

    private val httpLoggingInterceptor =
        HttpLoggingInterceptorHelper(HttpLoggerInterceptor).provideHttpLoggingInterceptor()

    private val httpHeaderInterceptor = HttpHeaderInterceptor()

    private val okHttpClient =
        OkHttpClientHelper(httpLoggingInterceptor, httpHeaderInterceptor).provideOkHttpClient()

    private val retrofit = RetrofitClientHelper(okHttpClient).provideRetrofitClient()

    private val browseApi = BrowseApiHelper(retrofit).provideBrowseApi()

    private fun browseRepository() = BrowseRepository(browseApi)

    private fun categoryMapper() = CategoryDtoToUiMapper()

    private fun categoriesMapper() = CategoriesDtoToUiMapper(categoryMapper())

    private fun playlistMapper() = PlaylistDtoToUiMapper()

    private fun playlistsMapper() = PlaylistsDtoToUiMapper(playlistMapper())

    fun browseInteractor(): BrowseInteractor {
        return BrowseInteractor(browseRepository(), categoriesMapper(), playlistsMapper())
    }

    fun categoriesPresenter(
        view: CategoriesContract.View,
        scope: CoroutineScope,
        browseInteractor: BrowseInteractor
    ): CategoriesPresenter {
        return CategoriesPresenter(view, scope, browseInteractor)
    }

    fun playlistsPresenter(
        categoryId: String,
        view: PlaylistContract.View,
        scope: CoroutineScope,
        browseInteractor: BrowseInteractor
    ): PlaylistsPresenter {
        return PlaylistsPresenter(categoryId, view, scope, browseInteractor)
    }
}