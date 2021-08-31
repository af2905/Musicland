package com.github.af2905.musicland.di

import com.github.af2905.musicland.data.network.OkHttpClientHelper
import com.github.af2905.musicland.data.network.RetrofitClientHelper
import com.github.af2905.musicland.data.network.api.BrowseApiHelper
import com.github.af2905.musicland.data.network.interceptor.HttpHeaderInterceptor
import com.github.af2905.musicland.data.network.interceptor.HttpLoggerInterceptor
import com.github.af2905.musicland.data.network.interceptor.HttpLoggingInterceptorHelper
import com.github.af2905.musicland.data.repository.BrowseRepository
import com.github.af2905.musicland.domain.interactor.BrowseInteractor

object DependencyInjector {

    private val httpLoggingInterceptor =
        HttpLoggingInterceptorHelper(HttpLoggerInterceptor).provideHttpLoggingInterceptor()

    private val httpHeaderInterceptor = HttpHeaderInterceptor()

    private val okHttpClient =
        OkHttpClientHelper(httpLoggingInterceptor, httpHeaderInterceptor).provideOkHttpClient()

    private val retrofit = RetrofitClientHelper(okHttpClient).provideRetrofitClient()

    private val browseApi = BrowseApiHelper(retrofit).provideBrowseApi()

    private fun browseRepository() = BrowseRepository(browseApi)

    fun browseInteractor(): BrowseInteractor {
        return BrowseInteractor(browseRepository())
    }

}