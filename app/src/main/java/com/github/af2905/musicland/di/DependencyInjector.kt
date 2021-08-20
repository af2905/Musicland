package com.github.af2905.musicland.di

import com.github.af2905.musicland.data.network.OkHttpClientHelper
import com.github.af2905.musicland.data.network.RetrofitClientHelper
import com.github.af2905.musicland.data.network.api.BrowseApiHelper
import com.github.af2905.musicland.data.network.interceptor.HttpHeaderInterceptor
import com.github.af2905.musicland.data.network.interceptor.HttpLoggerInterceptor
import com.github.af2905.musicland.data.network.interceptor.HttpLoggingInterceptorHelper
import com.github.af2905.musicland.data.repository.BrowseRepository

class DependencyInjector {

    private val httpLoggingInterceptor =
        HttpLoggingInterceptorHelper(HttpLoggerInterceptor).provideHttpLoggingInterceptor()

    private val httpHeaderInterceptor = HttpHeaderInterceptor()

    private val okHttpClient =
        OkHttpClientHelper(httpLoggingInterceptor, httpHeaderInterceptor).provideOkHttpClient()

    private val retrofit = RetrofitClientHelper(okHttpClient).provideRetrofitClient()

    private val browseApi = BrowseApiHelper(retrofit).provideBrowseApi()

    fun browseRepository() = BrowseRepository(browseApi)

}